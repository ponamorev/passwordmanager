package ru.penzgtu.ponamorev.passwordmanagement.contollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.penzgtu.ponamorev.passwordmanagement.domain.Device;
import ru.penzgtu.ponamorev.passwordmanagement.domain.Password;
import ru.penzgtu.ponamorev.passwordmanagement.repositories.DeviceRepository;
import ru.penzgtu.ponamorev.passwordmanagement.repositories.PasswordRepository;

import javax.validation.Valid;
import java.util.Iterator;

@Controller
@Slf4j
public class AppController {
    private final DeviceRepository deviceRepository;
    private final PasswordRepository passwordRepository;

    public AppController(DeviceRepository deviceRepository, PasswordRepository passwordRepository) {
        this.deviceRepository = deviceRepository;
        this.passwordRepository = passwordRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/auth_index")
    public String authorizedIndex() {
        return "auth_index";
    }

    @GetMapping("/device/add")
    public String goToAddNewDevicePage() {
        return "add-device";
    }

    @PostMapping("/device/add")
    public String addNewDeviceToDb(@Valid Device device,
                                   BindingResult result,
                                   Model model) {
        if (result.hasErrors()) {
            log.error("There was an error during getting new device data");
            return "error-page";
        }

        deviceRepository.save(device);
        model.addAttribute("devices", deviceRepository.findAll());
        return "get-all-devices";
    }

    @GetMapping("/device/all")
    public String getAllDeviceInfo(Model model) {
        Iterator<Device> iterator = deviceRepository.findAll().iterator();
        if (iterator.hasNext()) {
            model.addAttribute("devices", deviceRepository.findAll());
        } else {
            model.addAttribute("devices", null);
        }
        return "get-all-devices";
    }

    @PostMapping("/device/pass-update")
    public String updatePassForDevice(@Valid Password password,
                                      BindingResult result,
                                      Model model) {
        if (result.hasErrors()) {
            log.error("There was an error during updating password for device {}", password.getDeviceId());
            return "error-page";
        }

        passwordRepository.save(password);
        log.info("Password successfully updated");
        model.addAttribute("device", deviceRepository.findById(password.getDeviceId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid device ID: " + password.getDeviceId())));
        return "pass-updated";
    }
}