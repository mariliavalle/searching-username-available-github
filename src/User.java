import excecao.ErroVazio;

public class User {
    private String nome;
    private String bio;

    public User(String nome, String bio) {
        this.nome = nome;
        this.bio = bio;
    }


    public User(UserGitHub userGitHub) throws ErroVazio {
        if (userGitHub.name() == null){
            throw new ErroVazio("ID disponível para uso.");
        }
        this.nome = userGitHub.name();
        this.bio = userGitHub.bio();
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " " +
                "Bio: " + bio;
    }
}
