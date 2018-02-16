/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import java.util.Objects;

/**
 *
 * @author Anelia
 */
public class EncryptedCode {
    int cryptogram;
    String code;

    public EncryptedCode(String code) {
        this.cryptogram=5;
        setCode(code);
    }

    public EncryptedCode(String code, int crypto) {
        this.cryptogram = crypto;
        setCode(code);
    }
    
    public int getCryptogram() {
        return cryptogram;
    }

    public void setCryptogram(int cryptogram) {
        this.cryptogram = cryptogram;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = new String(code);
    }
    
    
    public void iterCryptogram(){
    cryptogram++;
    }

    @Override
    public String toString() {
        return  code;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EncryptedCode)) {
            return false;
        } else {
            String str=new String(((EncryptedCode) obj).getCode());
            return (this.code.equals(((EncryptedCode) obj).getCode()));
        }
    }
    
    
}
