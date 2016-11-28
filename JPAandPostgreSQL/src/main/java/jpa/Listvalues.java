/*

 */
package jpa;

/**
 *
 * @author saara
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Listvalues")
public class Listvalues implements Serializable {

    @Id

    @Column(name = "id")
    private int id;
    @Column(name = "value")
    private String value;
    @Column(name = "listnumber")
    private int listnumber;
    
    protected Listvalues(){
        
    }

    public Listvalues(int id, String value, int listnumber) {
        this.id = id;
        this.value = value;
        this.listnumber = listnumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getListnumber() {
        return listnumber;
    }

    public void setListnumber(int listnumber) {
        this.listnumber = listnumber;
    }
    
}
