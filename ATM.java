import java.util.Scanner;
class WrongPinException extends Exception
{
    WrongPinException(String str1)
  {
    super(str1);
  }
}
class CorrectPinException extends Exception
{
    CorrectPinException(String str2)
 {
     super(str2);
 }
}
class AtmDetails
{
    String CardHolder="DavidBrian";
    public long CardNumber=1234567891234567l;
    private int AtmPin;
    public int getAtmPin()
    {
    return AtmPin;
    }
    public void setAtmPin(int NewAtmPin)
    {
        this.AtmPin=NewAtmPin;
    }
}
public class ATM extends AtmDetails{
    public static void main(String[] args) throws WrongPinException, CorrectPinException{
        Scanner sc=new Scanner(System.in);
        AtmDetails myobj=new AtmDetails();
        System.out.println("Insert ATM Card...");
        System.out.println("Welcome!\t"+myobj.CardHolder);
        System.out.println("Enter Your 4-Digit Pin:");
        int AcctBalance=25000;
        int ATMPin=sc.nextInt();
        myobj.setAtmPin(9999);
        int NewAtmPin1=myobj.getAtmPin();
        boolean ActDetails=true;
        while (ActDetails)
        {
            try {
                if(ATMPin!=NewAtmPin1) {
                throw new WrongPinException("Invalid Pin\nTry Again"); 
                }
                else{
                throw new CorrectPinException("Select Your choice");
                }
            }
            catch (WrongPinException Ex1) {
                System.out.println(Ex1);
                break;
            }
            catch (CorrectPinException Ex2){
                System.out.println(Ex2);
            }
            System.out.println("1-Fast Cash \t\t\t\t 4-Change Pin");
            System.out.println("2-Cash WithDrawl\t\t\t\t 5-Deposit");
            System.out.println("3-Balance Enquiry\t\t\t\t 6-Transfer\n7-Exit");
            int Option=sc.nextInt();
            switch (Option){
                case 1:
                    System.out.println("Select Your Amount in Rupees");
                    System.out.println("1-100\t\t\t3-500\n2-200\t\t\t4-2000");
                    int FstCashOpt=sc.nextInt();
                    switch (FstCashOpt){
                        case 1:
                            if(AcctBalance>=100)
                            {
                                AcctBalance -= 100;
                                System.out.println("Collect Your Cash");
                            }
                            else
                                System.out.println("Insufficient Balance");break;
                        case 2:
                            if(AcctBalance>=200)
                            {
                                AcctBalance -= 200;
                                System.out.println("Collect Your Cash");
                            }
                            else System.out.println("Insufficient Balance");break;
                        case 3:
                            if(AcctBalance>=500)
                            {
                                AcctBalance -= 500;
                                System.out.println("Collect Your Cash");
                            }
                            else System.out.println("Insufficient Balance");break;
                        case 4:
                            if(AcctBalance>=2000)
                            {
                                AcctBalance -= 2000;
                                System.out.println("Collect Your Cash");
                            }
                            else System.out.println("Insufficient Balance");break; }break;
                case 2:
                    System.out.println("Enter Money to WithDraw:");
                    int WithDrawl=sc.nextInt();
                    if(AcctBalance>=WithDrawl) {
                        AcctBalance-=WithDrawl;
                        System.out.println("Please Collect Your Cash...");
                    }
                    else
                        System.out.println("Insufficient Balance...");
                        break;
                case 3:
                    System.out.println("Your Current Balance:"+AcctBalance);
                    break;
                case 4:
                    System.out.println("Enter Your New 4-DigitPin:");
                    int NewPin=sc.nextInt();
                    NewPin=NewAtmPin1;
                    System.out.println("Pin Changed Successfully...");
                    break;
                case 5:
                    System.out.println("Deposit Your Money in Rupees:");
                    int DepMoney=sc.nextInt();
                    AcctBalance+=DepMoney;
                    System.out.println("You Money has been Successfully Deposited");
                    break;
                case 6:
                    System.out.println("Enter Acct Number to Transfer:");
                    long TransAcct=sc.nextLong();
                    System.out.println("Enter Amount in Rupees to Transfer:");
                    int TransMoney=sc.nextInt();
                    AcctBalance-=TransMoney;
                    System.out.println("Transcation Done!");
                    break;
                case 7:
                    System.out.println("Thank You! Visit Again");
                    System.exit(0);
            }
            System.out.println("Would You Like to do further Transactions");
            System.out.println("Hit Y/N");
            char ch=sc.next().charAt(0);
            if(ch == 'Y')
                continue;
            else if(ch=='N')
                System.out.println("Thank You! Visit Again...");break;
        }
    }
}
