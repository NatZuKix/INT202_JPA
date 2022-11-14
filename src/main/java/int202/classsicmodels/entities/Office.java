package int202.classsicmodels.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@Table(name = "Offices")
@Setter
@NamedQueries({
        @NamedQuery(name = "FINDBYCITYORCOUNTRY", query = "select o from Office o where  lower(o.city) like : city  or  lower(o.country) like : country")
})
public class Office
{
    @Id
    private String officeCode;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String territory;
    @OneToMany(mappedBy = "officeCode")
    private  List<Employee> employee;
}