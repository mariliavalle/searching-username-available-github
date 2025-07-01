import com.google.gson.Gson;
import excecao.ErroVazio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ErroVazio {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Busque usuário por username:");
        String username = scanner.nextLine();

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/users/" + username))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new Gson();
            UserGitHub userGitHub = gson.fromJson(json, UserGitHub.class);

            User user = new User(userGitHub);
            System.out.println(user);
        } catch (ErroVazio e){
            System.out.println(e.getMessage());
        }

    }
}