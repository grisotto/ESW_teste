public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    /**
     *
     * @param id
     * @param nome
     */
    public Pessoa(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    /**
     *
     */
    public Pessoa() {
    }
    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }
    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }
    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


}

@Entity
@Table
@SuppressWarnings("PersistenceUnitPresent")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @NotNull
    @Column(unique = true)
    private String login;
    public String senha;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

     @OneToOne(mappedBy = "usuario")
    private Medico medico;

    @OneToOne(mappedBy = "usuario")
    private Paciente paciente;

    public Usuario() {
    }

    /**
     *
     * @param login
     * @param senha
     * @param tipoUsuario
     */
    public Usuario(String login, String senha, TipoUsuario tipoUsuario) {
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    /**
     *
     * @param id
     * @param login
     * @param senha
     */
    public Usuario(Integer id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    /**
     *
     * @param uu
     */
    public Usuario(Usuario uu) {
        setId(uu.getId());
        setLogin(uu.getLogin());
        setSenha(uu.getSenha());
        setTipoUsuario(uu.getTipoUsuario());
    }

    /**
     *
     * @param login
     * @param senha
     */
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public enum TipoUsuario implements GrantedAuthority {

        PACIENTE {
            @Override
            public String getAuthority() {
                return "PACIENTE";
            }
        },
        MEDICO {
            @Override
            public String getAuthority() {
                return "MEDICO";
            }
        },

        ADMIN {
            @Override
            public String getAuthority() {
                return "ADMIN";
            }
        };

        @Override
        public abstract String getAuthority();
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Medico getMedico() {
        return medico;
    }



    public void setMedico(Medico medico) {
        this.medico = medico;
    }

}

@Entity
@Table
@SuppressWarnings("PersistenceUnitPresent")
public class Paciente extends Pessoa {

    @Email
    @NotBlank
    @NotNull
    @Column(unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario user;

    @OneToOne
    private Consulta consulta;


    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Paciente(String email, Usuario usuario) {
        this.email = email;
        this.user = usuario;
    }

    public Paciente() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUsuario(Usuario usuario) {
        this.user = usuario;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

}

@Entity
@Table
@SuppressWarnings("PersistenceUnitPresent")
public class Medico extends Pessoa {

    @Email
    @NotBlank
    @NotNull
    @Column(unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;


    public Medico(String email, Usuario usuario) {
        this.email = email;
        this.usuario = usuario;
    }

    @OneToOne
    private Consulta consulta;


    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Medico() {
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
}

