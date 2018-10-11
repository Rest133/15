class Algorithm {
    int count;

     Algorithm() {
        for (int k = 0; k < 16; k++) {
            for (int j = k; j < Pyatnashki.invariants.length; j++) {
                System.out.println(Pyatnashki.invariants[k] + ">" + Pyatnashki.invariants[j] + "?");
                if (Pyatnashki.invariants[k] > Pyatnashki.invariants[j] && Pyatnashki.invariants[j] != 0) {
                    System.out.println("+");
                    count++;
                }
            }
        }
        System.out.println("Сумма без нуля " + count);
        System.out.println();
        for (int k = 0; k < 16; k++) {
            System.out.print(Pyatnashki.invariants[k] + " ");
        }
        for (int n = 0; n < Pyatnashki.invariants.length; n++) {
            if (Pyatnashki.invariants[n] == 0) {
                switch (n) {
                    case 0:
                        count++;
                        break;
                    case 1:
                        count++;
                        break;
                    case 2:
                        count++;
                        break;
                    case 3:
                        count++;
                        break;
                    case 4:
                        count += 2;
                        break;
                    case 5:
                        count += 2;
                        break;
                    case 6:
                        count += 2;
                        break;
                    case 7:
                        count += 2;
                        break;
                    case 8:
                        count += 3;
                        break;
                    case 9:
                        count += 3;
                        break;
                    case 10:
                        count += 3;
                        break;
                    case 11:
                        count += 3;
                        break;
                    case 12:
                        count += 4;
                        break;
                    case 13:
                        count += 4;
                        break;
                    case 14:
                        count += 4;
                        break;
                    case 15:
                        count += 4;
                        break;

                }
            }
        }
        System.out.println();
        System.out.println("Сумма c нулем " + count);
        System.out.println();

        if (count % 2 != 0) System.out.println("Нерешаемая комбинация");

        //Combination
        for (int x : Pyatnashki.invariants){
            if(x==1) System.out.println("Единица найдена");

        }
    }
}
