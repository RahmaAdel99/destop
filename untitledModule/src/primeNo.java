public class primeNo {
        static void checkPrime(int n){
            int flag=0;
            if(n==0||n==1){
                System.out.println(n+" is not prime number");
            }else{
                for(int i=2;i<=n/2;i++){
                    if(n%i==0){
                        System.out.println(n+" is not prime number");
                        flag=1;
                        break;
                    }
                }
                if(flag==0)  { System.out.println(n+" is prime number"); }
            }//end of else
        }
        public static void main(String args[]){
            checkPrime(1);
            checkPrime(3);
            checkPrime(17);
            checkPrime(20);
        }
    }

