package com.yong2ss.toberich.service.Draw;

import com.yong2ss.toberich.domain.draw.Draw;
import com.yong2ss.toberich.domain.draw.DrawRepository;
import com.yong2ss.toberich.domain.draw.DrawStatis;
import com.yong2ss.toberich.domain.draw.DrawStatisRepository;
import com.yong2ss.toberich.domain.lotto.Lotto;
import com.yong2ss.toberich.domain.lotto.LottoRepository;
import com.yong2ss.toberich.object.ApiConnect;
import com.yong2ss.toberich.object.CmFuntion;
import com.yong2ss.toberich.object.ExcelFunction;
import com.yong2ss.toberich.object.LottoFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DrawService {

    private static final List<Lotto> lottos = new ArrayList<>();
    List<Integer> allLotto = new ArrayList<>();

    @Autowired
    private LottoRepository lottoRepository;

    @Autowired
    private DrawRepository drawRepository;

    @Autowired
    private DrawStatisRepository drawStatisRepository;

    private List<DrawStatis> getDrawsByNum () {
        List<DrawStatis> draw = new ArrayList<>();

        List<DrawStatis> temp1 = drawStatisRepository.findStatisByNum1();
        List<DrawStatis> temp2 = drawStatisRepository.findStatisByNum2();
        List<DrawStatis> temp3 = drawStatisRepository.findStatisByNum3();
        List<DrawStatis> temp4 = drawStatisRepository.findStatisByNum4();
        List<DrawStatis> temp5 = drawStatisRepository.findStatisByNum5();
        List<DrawStatis> temp6 = drawStatisRepository.findStatisByNum6();

        for(int i = 1; i < 46; i++) {
            int sum = CmFuntion.drawStatisNVL(temp1.get(i)) + CmFuntion.drawStatisNVL(temp2.get(i))
                    + CmFuntion.drawStatisNVL(temp3.get(i)) + CmFuntion.drawStatisNVL(temp4.get(i))
                    + CmFuntion.drawStatisNVL(temp5.get(i)) + CmFuntion.drawStatisNVL(temp6.get(i));

            draw.add(new DrawStatis(i, sum));
        }

        return draw;
    }

    public Draw save() {
        Draw draw = this.doDraw();
        //TODO 보고 주석지워서 적용하기
        //drawRepository.save(draw);
        return draw;
    }

    private Draw doDraw() {
        //TODO 로또 로직
        //랜덤으로 6개 뽑기

        List<DrawStatis> statises = this.getDrawsByNum();

        //int sum = statises.stream().reduce(0, (a, b) -> a.getCnt() + b.getCnt());
        for(DrawStatis statis : statises) {
            this.addDrawsStatis(allLotto, statis.getLottoNum(), statis.getCnt());
        }

        ArrayList<Integer> targetList = new ArrayList<>();
        boolean valid = true;

        while(valid) {
            HashSet<Integer> drawSet = this.drawSet(allLotto.size());
            targetList = new ArrayList<>(drawSet);
            Collections.sort(targetList);

            if(LottoFunction.validCheck(targetList)) {
                valid = false;
            }
        }

        Draw draw = Draw.builder()
                        .draw1(targetList.get(0))
                        .draw2(targetList.get(1))
                        .draw3(targetList.get(2))
                        .draw4(targetList.get(3))
                        .draw5(targetList.get(4))
                        .draw6(targetList.get(5))
                        .drawDate(CmFuntion.getToday8())
                        .build();

        return draw;
    }

    private HashSet<Integer> drawSet (int size) {
        HashSet<Integer> temp = new HashSet<>();
        int tempNum = 0;
        while(temp.size() < 6) {
            tempNum = ThreadLocalRandom.current().nextInt(size);
            temp.add(allLotto.get(tempNum));
        }
        return temp;
    }

    private void addDrawsStatis (List<Integer> allLotto, int number, int cnt) {
        for(int i = 0; i < cnt ;i++) {
            allLotto.add(number);
        }
    }

    //
    private static void drawStart() {
        String select = "";
        System.out.println("a : alpha 로또추출 / b : beta 로또추출");
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, ArrayList<Integer>> data = new HashMap<>();

        select = scan.nextLine();
        int round = 0;

        switch (select) {
            case "a":
                System.out.println("Alpha");
                data = new ExcelFunction().lotto_excel_xlsx(7);
                function_alpha_normal(data);
                System.out.println();
                function_alpha_normal(data);
                System.out.println();
                function_alpha_normal(data);
                System.out.println();
                System.out.println("========== 6개");
                data = new ExcelFunction().lotto_excel_xlsx(6);
                function_alpha_normal(data);
                System.out.println();
                function_alpha_normal(data);

                break;
            case "b":
                System.out.println("Beta - 회차를 입력하세요 :");
                round = scan.nextInt();
                //function_beta(round);
                break;
            default:
                System.out.println("잘못 선택하셨습니다.");
                break;
        }
    }

    private static void function_alpha(HashMap<Integer, ArrayList<Integer>> data) {
        ArrayList temp = new ArrayList<>();
        HashSet a = new HashSet<>();
        int count = 0;
        int [] all = new int[3000000];
        for(int i = 0; i < data.size(); i++) {
            temp = data.get(i);
            for(int j=1; j<=(i+1); j++) {
                for(int k=0;k<temp.size();k++) {
                    count++;
                    all[count] = (int) temp.get(k);
                    a.add(all[count]);
                }
            }
        }

        HashSet result = new HashSet<>();
        Random randomNum = new Random();
        int lotto = 0;

		/*이건 진짜 주석
		int count1 = 0;
		int temp1 = 0;
		int count2 = 0;
		HashSet<Integer> abc = new HashSet<>();
		while (count2 < 10 || abc.size() < 6) {
			count1++;
			temp1 = randomNum.nextInt(count);
			count2 += checknum(temp1,abc);
		}
		System.out.println("=====당첨번호 [순차 + " + data.get(0).size() + "개]" + + count1 + "번입니다 =====");
		*/

        while(result.size() < 6) {
            lotto = randomNum.nextInt(count);
            result.add(all[lotto]);
        }

        Iterator it = result.iterator();
        System.out.println("=====당첨번호 [순차 + " + data.get(0).size() + "개]=====");
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }

    private static void function_alpha_reverse(HashMap<Integer, ArrayList<Integer>> data) {
        ArrayList temp = new ArrayList<>();
        HashSet a = new HashSet<>();
        int count = 0;
        int [] all = new int[3000000];
        int dataSize = data.size();

        for(int i = 0; i < dataSize; i++) {
            temp = data.get(i);
            for(int j = dataSize; j>=(i+1) ; j--) {
                for(int k=0;k<temp.size();k++) {
                    count++;
                    all[count] = (int) temp.get(k);
                    a.add(all[count]);
                }
            }
        }

        HashSet result = new HashSet<>();
        Random randomNum = new Random();
        int lotto = 0;

/*		이건진짜주석  int count1 = 0;
		int temp1 = 0;
		int count2 = 0;
		HashSet<Integer> abc = new HashSet<>();
		while (count2 < 10 || abc.size() < 6) {
			count1++;
			temp1 = randomNum.nextInt(count);
			count2 += checknum(temp1,abc);
		}
		System.out.println("=====당첨번호 [리버스 + " + data.get(0).size() + "개]" + + count1 + "번입니다 =====");
		*/

        while(result.size() < 6) {
            lotto = randomNum.nextInt(count);
            result.add(all[lotto]);
        }

        Iterator it = result.iterator();
        System.out.println("=====당첨번호 [리버스 + " + data.get(0).size() + "개] =====");
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }

    public static void function_alpha_normal (HashMap<Integer, ArrayList<Integer>> data) {
        ArrayList temp = new ArrayList<>();
        HashSet a = new HashSet<>();
        int count = 0;
        int [] all = new int[3000000];
        int dataSize = data.size();

        for(int i = 0; i < dataSize; i++) {
            temp = data.get(i);
            for(int k=0; k < temp.size(); k++) {
                count++;
                all[count] = (int) temp.get(k);
                a.add(all[count]);
            }
        }

        HashSet result = new HashSet<>();
        Random randomNum = new Random();
        int lotto = 0;
        Boolean checkValid = false;
        ArrayList<Integer> valid = new ArrayList<>();

        while(!checkValid) {
            result.clear();
            valid.clear();

            while(result.size() < 6) {
                lotto = randomNum.nextInt(count);
                result.add(all[lotto]);
            }

            Iterator it = result.iterator();
            while(it.hasNext()) {
                valid.add((int)it.next());
            }
//			System.out.println(valid.get(0) + " " + valid.get(1) + " " + valid.get(2)
//								+ " " + valid.get(3) + " " + valid.get(4)+ " " + valid.get(5));

            checkValid = new LottoFunction().validCheck(valid);
        }

        System.out.println("=====당첨번호[노말 + " + data.get(0).size() + "개]=====");
        for(int k : valid) {
            System.out.print(k + " ");
        }
    }

    public void function_beta (int round) {
        int [] lottoNum = new ApiConnect().lotto_json(round);
        Integer lottoNumInteger[] = Arrays.stream(lottoNum).boxed().toArray(Integer[]::new);
        LottoFunction lotto = new LottoFunction();

        Integer [] answer = lotto.beta(lottoNumInteger);

        System.out.println("추첨번호 [START]");
        for(int a : answer) {
            System.out.print(a + " - ");
        }
        System.out.println("추첨번호 [END]");
    }

    public static int checknum (int a, HashSet<Integer> abc) {
        if(a == 18 || a == 21 || a == 28 || a == 35 || a == 37 || a == 42) {
            abc.add(a);
            return 1;
        }
        return 0;
    }

}
