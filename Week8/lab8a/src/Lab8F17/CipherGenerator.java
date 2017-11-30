package Lab8F17;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class CipherGenerator {

    public Result countDistinct(Cipherable cipher, int seed){
        char[] code = cipher.getSecretChars(seed);
        int[] counters = new int[26];
        int distinct = 0 ;
        for (int i = 0; i < code.length; i++) {
            ++counters[(code[i]- 'A')];
        }
        for (int i = 0; i < counters.length; i++) {
            if(counters[i] == 1)
                distinct++;
        }
        return new Result(code, distinct);
    }
}
