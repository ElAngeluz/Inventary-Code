package asiste.incode;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //para desaparacer la barra con el titulo que es el nombre de la aplicacion

        //volvemos la aplicacion de pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.login_activity);//pone en la pantalla la vista

        Button button= (Button) findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Login.this,welcome.class));
            }
        });
        }

    public void login(View view){

        String nombre_usuario, contraseña; //declaramos strings a usar en el manejo de los datos

        EditText nombreUsuario = (EditText)findViewById(R.id.usuario); //referenciamos el objeto en nuestro xml
        nombre_usuario = nombreUsuario.getText().toString();

        EditText contraseñaUsuario = (EditText)findViewById(R.id.contraseña); //referenciamos el objeto en nuestro xml
        contraseña = contraseñaUsuario.getText().toString();//convertimos el texto en el campo de texto a string
                                                            //para almacenarlo en una string y manejar el envio de datos

        Toast.makeText(this, "usuario: "+nombre_usuario, Toast.LENGTH_SHORT).show(); //asi es como mandamos un mensaje al usuario
        Toast.makeText(this, "contraseña: "+contraseña, Toast.LENGTH_SHORT).show(); //asi es como mandamos un mensaje al usuario
        //TO-DO
        //implementar una background activity que se encargue de enviar los datos del usuario al servidore
        //en el servidor tienes que recibir los datos, checar que coincidan y devolver una respuesta
        //a la aplicacion para que puedas proceder

        int respuesta =1 ; //supongamos que esta es la respuesta del servidor (en realidad la conexion y el manejo de la)
                            //respuesta se manejan en otro archivo, pero tomalo como un ejemplo

        /*if(respuesta==1)
        {
            Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Contraseña o usuario incorrecto", Toast.LENGTH_SHORT).show();
        }*/
    }

    }
