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