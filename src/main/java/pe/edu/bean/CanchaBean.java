

package pe.edu.bean;

import java.io.Serializable;


public class CanchaBean implements Serializable{
    public String id;
    public String local;

    public CanchaBean(String id, String local) {
        this.id = id;
        this.local = local;
    }
    
    public CanchaBean(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    
    
    
}
