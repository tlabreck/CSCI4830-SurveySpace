package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "choice")
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    
    @Column(name = "value", nullable = false)
    private String value;
    
    @Column(name = "response_count", nullable = false)
    private int responseCount;
    
    public Choice(int id, String value) {
        setId(id);
        setValue(value);
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
    
    public int getResponseCount() {
        return responseCount;
    }
    
    public void setResponseCount(int responseCount) {
        this.responseCount = responseCount;
    }
}
