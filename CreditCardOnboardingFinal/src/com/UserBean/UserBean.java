package com.UserBean;
public class UserBean
{
			    private String fname;
			    private String lname;
                private int age;
                private String gender;
                private String contactno;
                private boolean status;
                private String uid;
                private  String password;
                private String signid;
                public String accno;
                private String csname;
                
                
                public String getFname() {
                                return fname;
                }
                public void setFname(String fname) {
                                this.fname = fname;
                }
                
                
                public String getLname() {
                                return lname;
                }
                public void setLname(String lname) {
                                this.lname = lname;
                }
                
                
                public int getAge() {
                                return age;
                }
                public void setAge(int age) {
                                this.age = age;
                }
                
                
                public String getAns()
                {
                                return this.csname;
                }
                public void setAns(String csname)
                {
                                this.csname=csname;
                }
                
                
                
                public String getGender() {
                                return gender;
                }
                public void setGender(String gender) {
                                this.gender = gender;
                }
                
                
                
                public String getContactno() {
                                return contactno;
                }
                public void setContactno(String contactno) {
                                this.contactno = contactno;
                }
                
                
                public boolean isStatus() {
                                return status;
                }
                public void setStatus(boolean status) {
                                this.status = status;
                }
                
                
                public String getUid() {
                                return uid;
                }
                public void setUid(String uid) {
                                this.uid = uid;
                }
                
                
                public String getPassword() {
                                return password;
                }
                public void setPassword(String password) {
                                this.password = password;
                }
                
                
                public String getSignid() {
                                return signid;
                }
                public void setSignid(String signid)
                {
                                this.signid=signid;
                }
                
                
                public UserBean()
                {
                                
                }
                
                
                public void setAccNo(String fn,String ln) {
                                
                int nf=fn.length();
                
                int nl=ln.length();
                char fwfn=fn.charAt(0);
                char fwln=ln.charAt(0);
                char lwfn=fn.charAt(nf-1);
                char lwln=ln.charAt(nl-1);
                String fwfns=Character.toString(fwfn);
                String fwlns=Character.toString(fwln);
                String lwfns=Character.toString(lwfn);
                String lwlns=Character.toString(lwln);
                                this.accno = (fwfns+fwlns+this.getUid()+lwfns+lwlns).toUpperCase();
                }
                public String getAccNo()
                {
                                return this.accno;
                }
                
                
                
                //user
                public UserBean(String fname, String lname,String gender, int age , String contactno, String uid, String password, String signid) {
                                super();
                                this.fname = fname;
                                this.lname = lname;
                                this.age = age;
                                this.gender = gender;
                                this.contactno = contactno;
                                this.uid = uid;
                                this.password = password;
                                this.signid=signid;                            
                }
                
                //admin
                public UserBean(String signid, String password)
                {
                                this.signid=signid;
                                this.password=password;
                }
                //admin
                public UserBean(String fname, String lname,String gender,int age, String uid)
                {
                                this.fname=fname;
                                this.lname=lname;
                                this.gender=gender;
                                this.uid=uid;
                                this.age=age;
                }
                
}

