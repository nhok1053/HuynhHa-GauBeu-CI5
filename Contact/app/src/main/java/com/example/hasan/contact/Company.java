package com.example.hasan.contact;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ha San~ on 9/21/2016.
 */
public class Company implements Serializable{
    private String name;
    private String phone;
    private String website;

    public Company(String name, String phone, String website) {
        this.name = name;
        this.phone = phone;
        this.website = website;
    }
    /*
    * "FPT Software", "0473007575", "https://www.fpt-software.com"
"EWay", "+84432595450", "https://eway.vn"
"KMS", "+84838486888", "http://www.kms-technology.com"
"BraveBits", " +84463260066", "http://www.bravebits.vn"
"TechKids", "+841653005670", "http://techkids.vn"
    * */
private static List<Company> listCompany;
    public static List<Company> getListCompany(){
        if(listCompany==null){
            listCompany = new ArrayList<>();
                listCompany.add(new Company("FPT Software","0473007575","https://www.fpt-software.com"));
            listCompany.add(new Company("EWay","+84432595450","https://eway.vn"));
            listCompany.add(new Company("KMS","+84838486888","http://www.kms-technology.com"));
            listCompany.add(new Company("BraveBits","+84463260066","http://www.bravebits.vn"));
            listCompany.add(new Company("TechKids","+841653005670","http://techkids.vn"));
            }
return listCompany;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
