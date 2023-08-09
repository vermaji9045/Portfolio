package com.School.SchoolValleyProject.Model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "contact_msg")

@SqlResultSetMappings({
        @SqlResultSetMapping(name="SqlResultSetMapping.count",columns = @ColumnResult(name="cnt"))
})
@NamedQueries({
        @NamedQuery(name="Contact.findOpenMsgs",query = "SELECT c FROM Contact c where c.status=:status"),
        @NamedQuery(name = "Contact.updateMsgStatus",query = "UPDATE Contact c SET c.status=?1 where c.contactId=?2")
})

@NamedNativeQueries({

        @NamedNativeQuery(name="Contact.findOpenMsgsNative", query = "SELECT *from contact_msg c where c.status=:status",resultClass = Contact.class),
        @NamedNativeQuery(name="Contact.findOpenMsgsNative.count",query = "select count(*) as cnt from contact_msg c where c.status=:status", resultSetMapping = "SqlResultSetMapping.count"),
        @NamedNativeQuery(name="Contact.updateMsgStatusNative",query = "UPDATE contact_msg c SET c.status=?1 where c.contact_id=?2")
})
public class Contact extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    @Column(name="contact_id")
    private int contactId;


    @NotBlank(message = "Name must not be blank")
    @Size(min=3,message = "Name must be at least 3 characters long")
    private String name;
    @NotBlank(message = "Mobile number must not be Blank")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String mobileNum;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;
    @NotBlank(message = "Subject must not be blank")
    @Size(min=5,message = "Subject must be at least 5 characters long")
    private String subject;

    @NotBlank(message = "Message must not be Blank")
    @Size(min = 10,message = "Message must be an 10 characters long")
    private String message;

    private String status;


}
