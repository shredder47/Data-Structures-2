public class RecursiveExamples {


    public static void main(String[] args) {

        System.out.println(reverse("hello"));
        System.out.println(palindrome("racecar"));
        System.out.println(sumOfNaturalNumber(3));
        System.out.println(factorial(5));

    }

    //HELLO
    public static String reverse(String input){

        if(input.isEmpty()){
            return "";
        }
        return input.charAt(input.length()-1) + reverse(input.substring(0,input.length()-1));

    }

    //KAYAK
    public static boolean palindrome(String input){

        if(input.isEmpty() || input.length()==1){
            return true;
        }

        if(input.charAt(0) == input.charAt(input.length()-1)){
            return palindrome(input.substring(1,input.length()-1));
        }

        return false;

    }

    //2
    public static int sumOfNaturalNumber(int input){

        if(input == 0)
            return 0;

        return input + sumOfNaturalNumber(input - 1);
    }

    public static int factorial(int input){

        if(input == 1)
            return 1;

        return input * factorial(input - 1);


    }
}
