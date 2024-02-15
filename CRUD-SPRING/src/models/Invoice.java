package models;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Invoice {

    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private Double amount;
    private Double finalAmount;
    private String number;
    private String receivedDate;
    private String type;
    private String vendor;
    private String comments;
}
