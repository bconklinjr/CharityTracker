/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CharityTracker;

import java.util.Date;

/**
 *
 * @author brian2
 */
public class Donation {
    private double dAmount;
    private String ddDate;
    private Charity ccCharity;
    
    Donation (double amount, String date, Charity charity) {
        this.dAmount = amount;
        this.ddDate = date;
        this.ccCharity = charity;
    }
    
    public double getAmount () {
        return this.dAmount;
    }
    public String getDate () {
        return this.ddDate;
    }
    public Charity getCharity () {
        return this.ccCharity;
    }
}
