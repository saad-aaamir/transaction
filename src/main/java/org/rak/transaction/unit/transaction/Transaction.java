package org.rak.transaction.unit.transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Entity
@Table(name = "transaction_detail")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid")
    private String uuid;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "gurdian_name")
    private String guardianName;
    @Column(name = "school_name")
    private String schoolName;
    @Column(name = "amount")
    private String amount;
    @Column(name = "school_logo_url")
    private String schoolLogoUrl;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "card_type")
    private String cardType;
    @Column(name = "trans_ref_num")
    private String transRefNum;
    @Column(name = "grade")
    private String grade;


}
