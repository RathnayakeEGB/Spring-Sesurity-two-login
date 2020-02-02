package lk.sesurity.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.sesurity.entities.SuperUser;
import lk.sesurity.entities.User1;
import lk.sesurity.entities.User2;
import lk.sesurity.utils.InvalidUserClassException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

public class UserDetailsImpl implements UserDetails {


    private int id;

    private String username;

    private String email;


    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;


    UserDetailsImpl(){

    }

    UserDetailsImpl(int id ,String userName, String password,String email ,Collection<? extends GrantedAuthority> authorities){
        this.id =id;
        this.email = email;
        this.username =userName;
        this.password =password;
        this.authorities =authorities;
    }


    public static UserDetailsImpl build(SuperUser u ,Collection<? extends GrantedAuthority> authorities){

        if(u instanceof User1){

            User1 user = (User1) u;
            return new UserDetailsImpl(user.getId(),user.getUserName(),user.getPassword(),user.getEmail(),authorities);

        }else if(u instanceof User2){
            User2 user = (User2) u;
            return new UserDetailsImpl(user.getId(),user.getUserName(),user.getPassword(),user.getEmail(),authorities);

        }else {
            throw new InvalidUserClassException("User Class is Invalid ! ");
        }
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(getId(), user.getId());
    }


}
