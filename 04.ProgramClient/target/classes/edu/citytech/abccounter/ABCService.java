package edu.citytech.abccounter;

public class ABCService {

    static boolean isVowel(String input){
        var status = input.matches("[AEIOUaeiou]");
        return status;
    }

    static boolean isConsonant(String input){
        var status = !isVowel(input);
        return status;
    }
    static boolean isEven(String input){
        Boolean status = true;
        if(Integer.parseInt(input) % 2 == 0)
        {
            status = true;
        }else
        {
            status = false;
        }

        return status;
    }
    static boolean isOdd(String input){
        var status = !isEven(input);
        return status;
    }
    static boolean isEvery6(String input){
        Boolean status = true;
        if(Integer.parseInt(input) % 6 == 0)
        {
            status = true;
        }else
        {
            status = false;
        }

        return status;
    }
    static boolean has4Or9(String input){
        String[] str = input.split("");

        for(int x = 0; x < str.length; x++)
        {
            if(Integer.parseInt(str[x]) == 4 || Integer.parseInt(str[x]) == 9)
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(ABCService.has4Or9("22"));

    }
}
