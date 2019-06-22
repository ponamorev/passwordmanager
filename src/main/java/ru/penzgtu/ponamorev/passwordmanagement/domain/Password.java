package ru.penzgtu.ponamorev.passwordmanagement.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Password must be related to device")
    private Long deviceId;
    @NotBlank(message = "Password must not be empty")
    private String password;

    public Password(Long deviceId,
                    String password) {
        this.deviceId = deviceId;
        this.password = password;
    }

    public Password() {}

    @Override
    public String toString() {
        return "Password for device " + getDeviceId() + " is " + getPassword();
    }
}