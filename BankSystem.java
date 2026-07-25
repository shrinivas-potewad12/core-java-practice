
    public class BankSystem {
        
        static class BankAccount {
            private String name;
            private int accNo;
            private int pin;
            private double balance;
            private ArrayList<String> history = new ArrayList<>();

            public BankAccount(String name, int accNo, int pin, double balance) {
                
                this.name = name;
                this.accNo = accNo;
                this.pin = pin;
                this.balance = balance;
                history.add(name + " account created with balance: " + balance);
                
            }

            public boolean checkPin(int inputPin) {
                return this.pin == inputPin;
            }

            public void deposit(double amount) {
                balance += amount;
                String msg = name + " deposited: " + amount;
                history.add(msg);
                System.out.println(msg);
            }

            public void withdraw(double amount) {
                if (amount <= balance) {
                    balance -= amount;
                    String msg = name + " withdrew: " + amount;
                    history.add(msg);
                    System.out.println(msg);
                } else {
                    System.out.println(name + " -> Insufficient Balance");
                }
            }

            public void transfer(BankAccount toAcc, double amount) {
                if (amount <= balance) {
                    balance -= amount;
                    toAcc.balance += amount;

                    String msg1 = name + " transferred " + amount + " to " + toAcc.name;
                    String msg2 = toAcc.name + " received " + amount + " from " + name;

                    history.add(msg1);
                    toAcc.history.add(msg2);

                    System.out.println(msg1);
                } else {
                    System.out.println(name + " -> Insufficient Balance");
                }
            }

            public void checkBalance() {
                System.out.println(name + " Balance: " + balance);
            }

            public void showHistory() {
                System.out.println("Transaction History of " + name);
                for (String h : history) {
                    System.out.println(h);
                }
            }

            public void display() {
                System.out.println("Name: " + name);
                System.out.println("Acc No: " + accNo);
                System.out.println("Balance: " + balance);
            }
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            HashMap<Integer, BankAccount> map = new HashMap<>();
            ArrayList<BankAccount> list = new ArrayList<>();

            BankAccount a1 = new BankAccount("Shinu", 101, 1111, 1000);
            BankAccount a2 = new BankAccount("Suraj", 102, 2222, 2000);
            BankAccount a3 = new BankAccount("Akshay", 103, 3333, 3000);

            map.put(101, a1);
            map.put(102, a2);
            map.put(103, a3);

            list.add(a1);
            list.add(a2);
            list.add(a3);

            System.out.println(" Welcome to Shinu Bank System");
            System.out.println("Accounts: Shinu, Suraj, Akshay");

            int choice;

            do {
                System.out.println("\n===== BANK MENU =====");
                System.out.println("1.Deposit");
                System.out.println("2.Withdraw");
                System.out.println("3.Check Balance");
                System.out.println("4.Transfer Money");
                System.out.println("5.Transaction History");
                System.out.println("6.Show All Accounts");
                System.out.println("7.Exit");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Acc No: ");
                        int dAcc = sc.nextInt();

                        if (map.containsKey(dAcc)) {
                            System.out.print("PIN: ");
                            int pin = sc.nextInt();

                            BankAccount d = map.get(dAcc);

                            if (d.checkPin(pin)) {
                                System.out.print("Amount: ");
                                d.deposit(sc.nextDouble());
                            } else {
                                System.out.println("Wrong PIN");
                            }
                        } else {
                            System.out.println("Account not found");
                        }
                        break;

                    case 2:
                        System.out.print("Acc No: ");
                        int wAcc = sc.nextInt();

                        if (map.containsKey(wAcc)) {
                            System.out.print("PIN: ");
                            int pin = sc.nextInt();

                            BankAccount w = map.get(wAcc);

                            if (w.checkPin(pin)) {
                                System.out.print("Amount: ");
                                w.withdraw(sc.nextDouble());
                            } else {
                                System.out.println("Wrong PIN");
                            }
                        } else {
                            System.out.println("Account not found");
                        }
                        break;

                    case 3:
                        
                        System.out.print("Acc No: ");
                        int cAcc = sc.nextInt();
                        

                        if (map.containsKey(cAcc)) {
                            System.out.print("PIN: ");
                            int pin = sc.nextInt();

                            BankAccount c = map.get(cAcc);

                            if (c.checkPin(pin)) {
                                c.checkBalance();
                            } else {
                                System.out.println("Wrong PIN");
                            }
                        } else {
                            
                            System.out.println("Account not found");
                        }
                        break;

                    case 4:
                        System.out.print("From Acc No: ");
                        int from = sc.nextInt();

                        System.out.print("To Acc No: ");
                        int to = sc.nextInt();

                        if (map.containsKey(from) && map.containsKey(to)) {

                            System.out.print("PIN: ");
                            int pin = sc.nextInt();

                            BankAccount sender = map.get(from);
                            BankAccount receiver = map.get(to);

                            if (sender.checkPin(pin)) {
                                System.out.print("Amount: ");
                                sender.transfer(receiver, sc.nextDouble());
                            } else {
                                System.out.println("Wrong PIN");
                            }

                        } else {
                            System.out.println("Account not found");
                        }
                        break;

                    case 5:
                        System.out.print("Acc No: ");
                        int hAcc = sc.nextInt();

                        if (map.containsKey(hAcc)) {
                            System.out.print("PIN: ");
                            int pin = sc.nextInt();

                            BankAccount h = map.get(hAcc);

                            if (h.checkPin(pin)) {
                                h.showHistory();
                            } else {
                                System.out.println("Wrong PIN");
                            }
                        } else {
                            System.out.println("Account not found");
                        }
                        break;

                    case 6:
                        for (BankAccount a : list) {
                            a.display();
                            System.out.println("------------");
                        }
                        break;

                    case 7:
                        System.out.println("Thank You!");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } while (choice != 7);

            sc.close();
        }
    }

