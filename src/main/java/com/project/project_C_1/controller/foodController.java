package com.project.project_C_1.controller;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.project.project_C_1.ProjectC1Application;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class foodController {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JacksonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    /***********************************/
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);//SPREADSHEETS_READONLY
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";


    //@Autowired
    //EmpresaDao empresaDao;

    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
    final String spreadsheetId = "1zgSp7P_FhB9bojNoDEE2Hb87bUJjKCkhKzvwY4aPlys";
    //final String spreadsheetId = "1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms";
    //final String range = "Class Data!A1:E";
    //final String range = "Sheet1!A2:B";
    final String range = "Sheet1!A2:D";

    public foodController() throws GeneralSecurityException, IOException {

    }

    @GetMapping("/sheets/{range_aux}")
    public List<List<Object>> getData(@PathVariable String range_aux) throws IOException {
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range_aux)
                .execute();
        return response.getValues();
    }
//    List<List<Object>> values = response.getValues();
//        if (values == null || values.isEmpty()) {
//        System.out.println("No data found.");
//    } else {
//        System.out.println("Name, Major");
//        for (List row : values) {
//            // Print columns A and E, which correspond to indices 0 and 4.
//            System.out.printf("%s, %s\n", row.get(0), row.get(1));
//        }
//    }

    //Escribir en spread sheet de google
    @PutMapping("/sheets")
    public void getAllPrueba1() throws IOException {
        //URL url = new URL("https://sheets.googleapis.com/v4/spreadsheets/1zgSp7P_FhB9bojNoDEE2Hb87bUJjKCkhKzvwY4aPlys/values/Sheet1!A1:D5?valueInputOption=USER_ENTERED");
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        String valueInputOption = "RAW";

        Date now = Calendar.getInstance().getTime();
        String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(now);
        String currentTime = new SimpleDateFormat("HH:mm", Locale.US).format(now);


        List<List<Object>> values = Arrays.asList(
                Arrays.asList(
                        new Object[] {currentDate, currentTime}
                        // Cell values ...
                )
                // Additional rows ...
        );
        ValueRange body = new ValueRange()
                .setValues(values);
        UpdateValuesResponse result = service.spreadsheets().values().update(spreadsheetId, range, body)
                .setValueInputOption(valueInputOption)
                .execute();
        System.out.printf("%d cells updated.", result.getUpdatedCells());
    }

    //Usar aplicacion como CLIENTE de otra url
    //PRUEBAAAAAAAAAAAAAAA
    @PostMapping("/getPrueba")
    public void getAllPrueba() throws IOException {
        URL url = new URL("https://sheets.googleapis.com/v4/spreadsheets/1zgSp7P_FhB9bojNoDEE2Hb87bUJjKCkhKzvwY4aPlys/values/Sheet1!A1:D5?valueInputOption=USER_ENTERED");
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
//            for (String line; (line = reader.readLine()) != null;) {
//                System.out.println(line);
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @PostMapping("/sheets")
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = ProjectC1Application.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        Credential autmario = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        return autmario;
    }
}

