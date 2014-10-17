/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CharityTracker;

import java.util.ArrayList;

/**
 *
 * @author brian2
 */
public class Donor {
    private String sName;
    private String sPhone;
    private ArrayList<Donation> History = new ArrayList<Donation>();
    
    Donor (String name, String phone) {
        this.sName = name;
        this.sPhone = phone;
    }
    public String getName () {
        return this.sName;
    }
    public String getPhone () {
        return this.sPhone;
    }
    public ArrayList<Donation> getHistory () {
        return this.History;
    }
    public Donation getDonation (int i) {
        return this.History.get(i);
    }
    
    public void MakeDonation (Donation donation) {
        this.History.add(donation);        
    }
}
