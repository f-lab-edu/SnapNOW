package kr.flab.snapnow.domain.auth.repository;

public interface RefreshRepository {
    
    public void insert(String email, String refreshToken);

    public void delete(String email);
}
