package com.androidbelieve.materialnavigationdrawer;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;


public class DiaActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;
    String navTitles[];
    TypedArray navIcons;
    RecyclerView.Adapter recyclerViewAdapter;
    ActionBarDrawerToggle drawerToggle;
    DBHandler db;
    private static DiaActivity instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        db = new DBHandler(this);
        if(db.traeEjercicio(40)==null)
            this.quemadura(db);



        //Let's first set up toolbar
        setupToolbar();

        //Initialize Views
        recyclerView  = (RecyclerView) findViewById(R.id.recyclerView);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerMainActivity);

        //Setup Titles and Icons of Navigation Drawer
        navTitles = getResources().getStringArray(R.array.navDrawerDias);
        navIcons = getResources().obtainTypedArray(R.array.navDrawerDiasIcons);


        /**
        *Here , pass the titles and icons array to the adapter .
        *Additionally , pass the context of 'this' activity .
        *So that , later we can use the fragmentManager of this activity to add/replace fragments.
        */

        recyclerViewAdapter = new RecyclerViewAdapterDias(navTitles,navIcons,this,toolbar,db);
        recyclerView.setAdapter(recyclerViewAdapter);

        /**
        *It is must to set a Layout Manager For Recycler View
        *As per docs ,
        *RecyclerView allows client code to provide custom layout arrangements for child views.
        *These arrangements are controlled by the RecyclerView.LayoutManager.
        *A LayoutManager must be provided for RecyclerView to function.
         */

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Finally setup ActionBarDrawerToggle
        setupDrawerToggle();


        //Add the Very First i.e Squad Fragment to the Container
        //Fragment squadFragment = new SquadFragment();
        Fragment welcfragment = new WelcomeFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerView,welcfragment,null);
        fragmentTransaction.commit();


    }

    public static synchronized DiaActivity getsetting() {
        if (instance == null) {
            instance = new DiaActivity();
        }
        return instance;
    }

    public void quemadura(DBHandler db)
    {
        Log.d("Insert","insertando");
        db.addExcersice(new Exercise
                (
                        1,
                        "Flexiones de pecho",
                        "Boca abajo y apoyado en palmas y puntas de los pies, con el cuerpo en posición horizontal, descienda el cuerpo flexionando los brazos evitando que el tronco o las rodillas toquen el suelo.",
                        "El ejercicio reduce la capacidad de las plaquetas para unirse a las placas de lípidos, lo cual reduce la posibilidad de que las arterias se ocluyan por trombos.",
                        "ex_1"
                ));
        db.addExcersice(new Exercise(2, "Flexiones Indias", "Boca abajo apoyado en palmas y puntas de los pies, con la pelvis en elevación y la cabeza a nivel de los codos, realize una trayectoria curva a medida que desciende la pelvis y eleva la cabeza", "1 kg de grasa ocupa casi el doble del espacio que 1 kg. de músculo.", "ex_2"));
        db.addExcersice(new Exercise(3, "Diamantes", "Boca abajo, apoyado sobre rodillas y palmas descienda el tronco procurando que no toque el suelo y regrese a la posición inicial", "El reducir el nivel de grasa corporal a medida que se aumenta el nivel de masa muscular  hará que se note como se marca la musculatura a nivel subcutáneo.", "ex_3"));
        db.addExcersice(new Exercise(4, "Deltoides boca abajo", "Recostado completamente boca abajo, con los brazos al frente, eleve tanto pierna como brazos y lleve estos últimos hacia los lados", "Estirar despues de hacer ejercicio permite mayor circulacion y mayor recuperacion muscular.", "ex_4"));
        db.addExcersice(new Exercise(5, "Barras", "Colgar de una barra con buena elevacion, e intentar subir el cuerpo usando solamente la fureza de los biceps", "El ejercicio retrasa los procesos de envejecimiento y disminuye la liberación de radicales libres.", "ex_5"));
        db.addExcersice(new Exercise(6, "Fondos", "Sujetarse de  dos barras paralelas y mantener el cuerpo sobre el aire, luego bajar utilizando solamente los brazos y volver a subir para completar el ejercicio.", "Hacer ejercicio hace que se aumente la densidad capilar y se dé una neovascularización en sitios importantes como el corazón, de manera que al crear más redes, si una de las arterias llega a colapsar, la irrigación puede ser dada por otros vasos, previniendo así un infarto.", "ex_6"));
        db.addExcersice(new Exercise(7, "Deltoides con banda", "Sujetando una banda elástica extienda ambos brazos al frente y sepárelos", "Con el ejercicio se pueden hacer ajustes crónicos al sistema nervioso central, tendiendo a la vagotonía, relacionado una actividad marcada del SNParasimpático, produciendo un descenso del inotropismo y aumentando la captación de O2 en los pulmones.", "ex_7"));
        db.addExcersice(new Exercise(8, "Espalda con banda", "Sentado en el piso con las piernas estiradas, coloque una banda elástica  en la plata de los pies, extienda los brazos para alcanzar los extremos y luego tire de ella hacia atrás con los brazos y la espalda", "Con la hipertrofia muscular, se consigue aumentar los depósitos de TAG en un 50% a un 100%.", "ex_8"));
        db.addExcersice(new Exercise(9, "Biceps con banda", "Sujetar los extremos de una banda elástica con los brazos, luego parase sobre ella y despues proceder a flexionar los codos.", "Cada libra de músculo (1 libra = 0,45 kilogramos) quema de 75 a 100 calorías cada día simplemente por estar en reposo.", "ex_9"));
        db.addExcersice(new Exercise(10, "Pectoral con banda", "Acosado sobre una banda elástica, sujete los extremos con las manos, estire los brazos y luego intente cerrarlos los mas posible. ", "El ejercicio aumenta los niveles de serotonina en el cerebro y te hace pensar con más claridad y ayuda a memorizar con más falcilidad (piensalo para estudiar).", "ex_10"));
        db.addExcersice(new Exercise(11, "Sentadillas", "Estando de pie, descienda el cuerpo flexionando ambas rodillas y retorne a la posición inicial, procure mantener la espalda recta", "En ejercicio intenso, casi todo el O2 almacenado en el cuarpo, se utiliza en 1 minuto, para el metabolismo aeróbico, por lo cual debe aumentar la dilatación de las narinas y es necesaria una respiración adecuada para poder responder adecuadamente al ejercicio, pudiendo llegar a consumir hasta unos 9L aproximadamente.", "ex_11"));
        db.addExcersice(new Exercise(12, "Zancadas", "Estando de pie, de un paso adelante y flexione ambas piernas procurando que la rodilla adelantada no sobrepase la punta del pie y la atrasada no toque el suelo, luego regrese a la posición inicial", "Una de las mejores adaptaciones del cuerpo al ejercicio, es la del incremento de red de capilares en los alvéolos pulmonares, lo cual se relaciona con un mejor intercambio gaseoso.", "ex_12"));
        db.addExcersice(new Exercise(13, "Elevación de talones", "Estando de pie váyase colocando lentamente de puntillas y descienda nuevamente hasta la posición inicial", "El exceso de grasa produce hormonas que inducen la sensación de estrés y aumentan la ansiedad, junto con otras hormonas que incrementan el hambre y con ello la obesidad.", "ex_13"));
        db.addExcersice(new Exercise(14, "Extensión de piernas", "Sentado, con el tronco erguido y los brazos a los costados, extienda una pierna hacia adelante de modo que esta quede en paralelo al suelo y retorne a la posición inicial", "El exceso de grasa corporal guarda estrecha relación con la elevación de la tensión arterial, al promover la creación de placas arteromatosas, donde luego se van a adherir plaquetas y ocluirán el vaso.", "ex_14"));
        db.addExcersice(new Exercise(15, "Marcha sin desplazamiento", "De pie, con los brazos flexionados en el pecho, flexione las piernas intercaladamente de modo que el talon intente tocar el glúteo con cada repetición", "Las respiraciones forzadas generadas por el ejercicio pueden contribuir a limpiar la vías aéreas de microorganismos.", "ex_15"));
        db.addExcersice(new Exercise(16, "Puente", "Acostado boca arriba, con las rodillas flexionadas y las plantas apoyandose en el suelo, eleve la pelvis hasta formar un puente recto entre los muslos y el tronco", "La elevación de la temperatura corporal producto del ejercicio puede contrubuir a combatir infecciones. Ya que la temperatura normal es de 37 grados, pero en condiciones de actividad física puede aumentar hasta los 42 grados aproximadamente, sin ser este, un estado patológico.", "ex_16"));
        db.addExcersice(new Exercise(17, "Patada atrás", "De rodillas y con las palmas apoyadas en el piso lleve la pierna hacia atrás sin extenderla y retorne a la posición inicial", "El corazón irá adaptando su capacidad de bombeo de acuerdo al tipo de ejercicio que usted realice. Ya sea de fuerza o de tipo aeróbico, lo cual hará que las paredes del corazón se hipertrofien, o que aumente el gasto cardiaco, respectivamente. Aunque se requiere de la combinación de ambos tipos de ejercicio para mejorar la salud.", "ex_17"));
        db.addExcersice(new Exercise(18, "Aductores", "Sentado, coloque ambos puños (o algún objeto como por ejemplo un balón) entre las rodillas, luego ejerca presión sobre los puños (o el objeto) con ambas rodillas y luego relaje", "La acción mecánica sobre el hueso promueve el recambio óseo, aumentando la creación del hueso y previniendo la osteoporosis.", "ex_18"));
        db.addExcersice(new Exercise(19, "Extensión de pierna recostado a la pared", "Recostando la espalda a la pared, con los brazos a los lados, flexione las rodillas de modo queden a la altura de la pelvis y posteriormente coloque el pie sobre la rodilla contralateral o extienda la pierna", "Realizar ejercicio muestra una influencia alta en el manejo y prevención de enfermedades como el Parkison y el Alzheimer, ayudando a mantener la integridad cerebral.", "ex_19"));
        db.addExcersice(new Exercise(20, "Escalón ", "Ubique un escalón y vaya intercalando la elevación de la pierna sobre este o realize saltos para ir colocando ambas encima del escalon", "El ejercicio induce la producción de neurotransmisores relacionados con la sensación de serenidad y calma.", "ex_20"));
        db.addExcersice(new Exercise(21, "Puente abdominal sobre balón medicinal", "En decúbito ventral o boca abajo sobre el suelo, debemos apoyar ambas manos sobre el balón medicinal y la punta de los pies en la superficie. Desde allí, mediante la contracción del abdomen, debemos despegar el cuerpo del suelo de manera de formar una línea recta desde la cabeza a los talones, mientras con los brazos extendidos nos apoyamos sobre un balón con las manos.", "Para alcanzar una adptación con el ejercicio físico y tener beneficios en la salud, éste debe practicarse con regualridad, mínimo 3 veces a la semana con una duración de 30 minutos.", "ex_21"));
        db.addExcersice(new Exercise(22, "Puente invertido", "Para comenzar el movimiento debemos sentarnos en el suelo y con las piernas extendidas hacia adelante, apoyamos las palmas de las manos en el suelo con los dedos hacia adentro, es decir, en dirección al cuerpo. Así, con los talones en el suelo, iniciamos el ejercicio.", "Hacer ejercicio requiere una elevada hidratación, la cual debe hacerse antes, durante y después de la actividad, con la finalidad de prevenir la deshidratación y rendir mejor.", "ex_22"));
        db.addExcersice(new Exercise(23, "Elevación lateral de piernas", "Para comenzar el movimiento debemos recostarnos de lado sobre una colchoneta o en el suelo, y colocando una mano detrás de la cabeza, sin despegar el antebrazo del lado apoyado del suelo, iniciamos el ejercicio.", "Al hacer ejercicio se hace un esfuerzo sobre músculos de las paerdes del abdomen, lo cual evita la aparición de hernias.", "ex_23"));
        db.addExcersice(new Exercise(24, "Puente lateral con torsión", "Para comenzar el movimiento debemos colocarnos de lado sobre el suelo y con el antebrazo apoyado en el suelo, la mano también apoyada y en dirección al frente, colocamos un pie sobre otro y con las puntas dirigidas al frente, elevamos todo el cuerpo para formar una línea desde los talones a la cabeza.", "La cantidad de AMP presente en los músculos, ncluso en un deportista bien entrenado, es suficiente para amntener la potencia muscular máxima durante únicamente 3 segundos, lo que podría ser suficiente para la mitad de una carrera de 50 metros.", "ex_24"));
        db.addExcersice(new Exercise(25, "Cruce alterno de piernas", "Debemos colocarnos en el suelo, tumbados boca arriba y apoyaremos los antebrazos con la finalidad de elevar el tronco. Extenderemos las piernas y despegaremos los pies del suelo para dar inicio al ejercicio.", "La práctica de ejercicio leve a moderado en un postoperatorio mejora las tazas de recuperación, haciendo que se dé más rápido y el paciente obtenga un mejoría pronta a nivel biopsicosocial.", "ex_25"));
        db.addExcersice(new Exercise(26, "Abdominales en V", "Debemos colocarnos en decúbito supino es decir, recostados sobre el suelo, con los brazos y piernas extendidas, las manos deben dirigirse hacia atrás por los lados de la cabeza y las palmas deben mirar hacia arriba.", "El entrenamiento aeróbico da lugar a adaptaciones celulares que aumentan las velocidades de eliminación de ácido láctico, así sólo se acumula con un ejercicio de muy alta intensidad.", "ex_26"));
        db.addExcersice(new Exercise(27, "Elevaciones de piernas extendidas en suelo", "Con la espalda totalmente apoyada en la superficie, flexionamos la cadera para elevar las piernas rectas hasta que éstas queden perpendiculares al tronco. Desde allí, con la cabeza, cuello y hombros sobre el suelo, comenzamos el movimiento.", "Las fibras de contracción lenta (tipo I) poseen muchas mitocrondrias, que aumentan con la realización de ejercicio, y con ello se genera mucho más ATP y se aumenta el ingreso de glucosa en el músculo. Esto se dá en el metabolismo aeróbico. ", "ex_27"));
        db.addExcersice(new Exercise(28, "Plancha", "Túmbate boca abajo y apoya el peso de tu cuerpo sobre tus antebrazos y la punta de los pies, manteniendo el cuerpo separado del suelo y rígido como una tabla. Mantén esa posición todo el tiempo.", "Entre las edades de 50 a 70 años, estudios demuestran que el realizar algún tipo de actividad física, reduce la mortalidad por lo menos en un 30%.", "ex_28"));
        db.addExcersice(new Exercise(29, "Escaladas", "A partir de la posición de plancha, jalas un pie hacia el pecho, regresas a la posición inicial y repites con el otro, como si estuvieras escalando una montaña.", "Un ejercicio moderado, inslusive sin disminución del peso, ha demostrado una mejoría en la sensibilidad a la insulina y con ello reducir e incluso eliminar la necesidad de un tratamiento farmacológico en pacientes con Diabetes tipo 2.", "ex_29"));
        db.addExcersice(new Exercise(30, "Abdominales cruzadas", "Acostada en el suelo bocarriba y con las piernas flexionadas, coloca las manos detrás de la nuca, levanta el tronco y rótalo de manera simultánea con la rodilla opuesta, acércala al pecho y mantén la posición un par de segundos. Vuelve a la posición inicial y repite con la otra pierna.", "En un entrenamiento de la fuerza, el músculo puede alcanzar una hipertrofia del 30%, pudiendo llegar con constancia a un 60%. ", "ex_30"));
        db.addExcersice(new Exercise(31, "Press banca decliando con macuernas", "Acuestate sobre un sillón o tu cama, dejando las piernas salir por el borde y haz fuerza con tu abdomen para reducir el espacio entre la superficie y tu espalda, luego toma las mancuernas (o dos botellas de agua de un litro) y eleva los brazos sobre tu pecho; luego manteniendo los codos ligeramente flexionados, baja las mancuernas con las manos alineadas con la zona media del pectoral.", "Según la OMS, alrededor del 3,2% de la población mundial muere a causa de la inactividad física, siendo ésta la cuarta causa de muerte más común.", "ex_31"));
        db.addExcersice(new Exercise(32, "Pullover con mancuerna", "Recuestate en una superficie plana y levanta una mancuerna o una botella llena de líquido y desciéndela hasta la parte posterior de tu cuerpo, sintiendo la tensión sobre los pectorales, los serratos y los triceps, luego sube nuevamente el objeto a nivel de tu cara.", "La realización de una actividad física moderada a intensa de 30 minutos diarios, está relacionada con la reducción de cáncer de cólon en un 80%.", "ex_32"));
        db.addExcersice(new Exercise(33, "Remo con mancuerna", "Eleva la mancuerna y llévala hasta tu cadera, en un movimiento lento y sin impulso. Una vez la mancuerna esté a nivel de la cadera, manten esa posición unos segundos y luego deja caer el peso lentamente.", "Hacer ejercicio aumenta considerablemente la mioglobina y las mitocondrias musculares, mejorando así la resistencia del cuerpo en un 50 a 100% en sesis semanas, además de posibilitar una mejor captación de O2.", "ex_33"));
        db.addExcersice(new Exercise(34, "Plancha lateral", "Colócate de lado y pon un pie sobre el otro, luego con la mano que tendrás de apoyo elevate completamente apoyándote sobre la mano y luego eleva el brazo libre alineándolo con aquel que está en la parte baja y el hombro. Mantén la posición unos segundos y luego desciende lentamente. Se debe hacer por ambos lados.", "Cuando haces ejercicio, se mejora la síntesis  de lipoproteínas en el hígado, en especial la de HDL, haciendo posible remover una mayor cantidad de colesterol de las paredes de las arterias y evitando los arteromas.", "ex_34"));
        db.addExcersice(new Exercise(35, "Deltoides posterior sentado con mancuerna o pájaros", "Sientate sobre una silla y luego inclina tu pecho sobre tus rodillas dejando, pon los brazos a un costado y luego mientras sueltas la respiración eleva los brazos a un lado.", "En las mujeres, el realizar ejercicio regularmente genera que durante el periodo menstrual se liberen endorfinas, lo que reduce el dolor de los cólicos por lo menos en un 55%. ", "ex_35"));
        db.addExcersice(new Exercise(36, "Press Arnold", "Sentado en una silla con los pies firmemente apoyados, sube las mancuernas y realiza un giro de muñeca, de forma que las palmas de las manos terminen colocadas al frente, luego realiza el movimiento opuesto mientras desciendes para que el codo quede mirando hacia el frente.", "El tener un entrenamiento constante aumenta la actividad parasimpática en las personas, lo cual facilita la disminución de la frecuencia cardiaca.", "ex_36"));
        db.addExcersice(new Exercise(37, "Elevaciones frontales", "Abre las piernas un poco y parate firmemente, luego dobla ligerametne las rodillas y pon las mancuernas frente a ti, con las manos en pronación, luego con los codos sin flexionar subre y baja de manera alterna las mancuernas.", "En pacientes con enfermedad cardiovascular confirmada, hacer deporte mejora la cantidad de O2 que llega al miocardio, relacionado con la reducción del tono simpático y el aumento de catecolaminas, reduciendo el riesgo de una muerte súbita.", "ex_37"));
        db.addExcersice(new Exercise(38, "Remo en punta con mancuerna", "Apoya la región glutea contra una pared, luego abriendo ligeramente las piernas flexiona las rodillas y posiciona tu cuerpo hacia anterior, manteniendo tu cabeza siempre mirando hacia al frente y los brazos con las mancuernas suspendidos a un lado con las manos en pronación y luego eleva los brazos a nivel del pecho de manera simultánea.", "La actividad física mejora la afinidad de los receptores de insulina por el músculo, haciendo que ingrese más glucosa y consistente con ello se reduzcan los triglicéridos en sangre, al evitar que ingresen altas cantidades al hígado y el tejido adiposo. ", "ex_38"));
        db.addExcersice(new Exercise(39, "Encogimientos con mancuernas", "Levanta los hombros lo máximo posible, conlas mancuernas en las manos, luego manten la contracción unos segundos y desciende hasta la posición de partida. ", "El ejercicio físico está relacionado con múltiples benefícios psicológicos al reducir la ansiedad, mejorar el autoconcepto y reducir el estrés.", "ex_39"));
        db.addExcersice(new Exercise(40, "Remo al mentón con mancuernas", "Levanta las mancuernas hacia el mentón con los codos elevados y manetn la posicón unos segundos, para posteriormente regresar al punto de partida. ", "Cuando realizas actividad física se aumenta la producción de sustancias vasodilatadoras, lo cual hace que el vaso mantenga su diámetro y se evite su colapso.", "ex_40"));

    }

    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle(){
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        drawerToggle.syncState();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {

            finish();
        }
        return super.onKeyDown(keyCode, event);
    }


}
