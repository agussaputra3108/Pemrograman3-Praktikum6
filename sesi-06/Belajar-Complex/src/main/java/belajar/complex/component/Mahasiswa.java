
package belajar.complex.component;

public class Mahasiswa {
    private String npm;
    private String nama;
    
    public String fetNpm(){
        return this.npm;
    }
    
    public void setNpm(String x){
        this.npm = x;
    }
    
    public String getName(){
        return this.nama;
    }
    
    public void setNama(String x){
        this.nama = x;
    }
    
    public string toString(){
        return "["+this.npm+"] - " +  this.nama;
    }
}
