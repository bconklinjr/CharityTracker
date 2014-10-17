/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CharityTracker;

/**
 *
 * @author brian2
 */
public class Charity {
    private String sName;
    private String sTaxId;
    
    Charity (String name, String taxid) {
        this.sName = name;
        this.sTaxId = taxid;
    }
    
    public String getName () {
        return this.sName;
    }
    public String getTaxId () {
        return this.sTaxId;
    }
}
