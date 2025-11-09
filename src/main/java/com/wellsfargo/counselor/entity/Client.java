package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String address;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Portfolio> portfolios = new ArrayList<>();

    public Client() {}

    public Client(String firstName, String lastName, String address, String phone, String email, Advisor advisor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.advisor = advisor;
    }

    public Long getClientId() { return clientId; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Advisor getAdvisor() { return advisor; }
    public void setAdvisor(Advisor advisor) { this.advisor = advisor; }
    public List<Portfolio> getPortfolios() { return portfolios; }
    public void setPortfolios(List<Portfolio> portfolios) { this.portfolios = portfolios; }
}
