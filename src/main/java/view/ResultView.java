/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 * @author Korwin Bieniek
 * @version 1.0.1
 */
public class ResultView {

    /**
     * @param nwdValue - the result of calculating NWD
     * @param nwwValue - the result of calculating NWW
     */
    public void printValue(int nwdValue, int nwwValue) {
        System.out.println("NWD Value: " + nwdValue
                + " NWW Value:" + nwwValue);
    }
}
