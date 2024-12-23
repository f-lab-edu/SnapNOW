package kr.flab.snapnow.application.auth.output;

import java.util.List;

import kr.flab.snapnow.domain.auth.DeviceCredential;

public interface DeviceCredentialOutputPort {

    void insert(DeviceCredential deviceCredential);

    DeviceCredential get(Long userId, String deviceId);

    List<DeviceCredential> getAll(Long userId);

    void update(DeviceCredential deviceCredential);

    void delete(Long userId, String deviceId);
}
