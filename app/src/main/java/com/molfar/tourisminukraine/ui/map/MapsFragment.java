package com.molfar.tourisminukraine.ui.map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.molfar.tourisminukraine.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment implements GoogleMap.OnInfoWindowClickListener{
    GoogleMap map;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            map = googleMap;

            //add markers on map

            LatLng location11 = new LatLng(49.663258, 25.785249);
            MarkerOptions options11 = new MarkerOptions();
            options11.position(location11);
            options11.title("Збаразький замок");
            options11.snippet("");
            options11.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat1_castle));

            LatLng location12 = new LatLng(49.943122, 24.983618);
            MarkerOptions options12 = new MarkerOptions();
            options12.position(location12);
            options12.title("Підгорецький замок");
            options12.snippet("");
            options12.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat1_castle));

            LatLng location13 = new LatLng(49.059823, 25.391620);
            MarkerOptions options13 = new MarkerOptions();
            options13.position(location13);
            options13.title("Бучацький замок");
            options13.snippet("");
            options13.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat1_castle));

            LatLng location14 = new LatLng(48.521950, 26.498200);
            MarkerOptions options14 = new MarkerOptions();
            options14.position(location14);
            options14.title("Хотинська фортеця");
            options14.snippet("");
            options14.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat1_castle));

            LatLng location15 = new LatLng(49.436600, 27.411658);
            MarkerOptions options15 = new MarkerOptions();
            options15.position(location15);
            options15.title("Меджибізький замок");
            options15.snippet("");
            options15.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat1_castle));

            LatLng location16 = new LatLng(48.673568, 26.562412);
            MarkerOptions options16 = new MarkerOptions();
            options16.position(location16);
            options16.title("Кам'яне́ць-Поді́льська форте́ця");
            options16.snippet("");
            options16.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat1_castle));

            LatLng location17 = new LatLng(50.738773, 25.323102);
            MarkerOptions options17 = new MarkerOptions();
            options17.position(location17);
            options17.title("Замок Любарта");
            options17.snippet("");
            options17.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat1_castle));

            LatLng location18 = new LatLng(46.201216, 30.349918);
            MarkerOptions options18 = new MarkerOptions();
            options18.position(location18);
            options18.title("Білгород-Дністровська фортеця");
            options18.snippet("");
            options18.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat1_castle));

            LatLng location19 = new LatLng(50.094762, 25.730580);
            MarkerOptions options19 = new MarkerOptions();
            options19.position(location19);
            options19.title("Кременецький замок");
            options19.snippet("");
            options19.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat1_castle));

            LatLng location110 = new LatLng(49.299401, 25.683222);
            MarkerOptions options110 = new MarkerOptions();
            options110.position(location110);
            options110.title("Теребовлянський замок");
            options110.snippet("");
            options110.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat1_castle));

            LatLng location111 = new LatLng(48.804010, 25.596905);
            MarkerOptions options111 = new MarkerOptions();
            options111.position(location111);
            options111.title("Червоногрудський замок");
            options111.snippet("");
            options111.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat1_castle));

            LatLng location112 = new LatLng(51.342598, 32.886276);
            MarkerOptions options112 = new MarkerOptions();
            options112.position(location112);
            options112.title("Батуринська фортеця 'Цитадель'");
            options112.snippet("");
            options112.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat1_castle));

            LatLng location113 = new LatLng(50.47750300273514, 29.21640124886891);
            MarkerOptions options113 = new MarkerOptions();
            options113.position(location113);
            options113.title("Замок-музей Радомисль");
            options113.snippet("");
            options113.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat1_castle));

            LatLng location21 = new LatLng(49.899183, 25.738435);
            MarkerOptions options21 = new MarkerOptions();
            options21.position(location21);
            options21.title("Палац Вишневецьких");
            options21.snippet("");
            options21.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat2));

            LatLng location22 = new LatLng(50.116130, 26.819067);
            MarkerOptions options22 = new MarkerOptions();
            options22.position(location22);
            options22.title("Палац Сангушків");
            options22.snippet("");
            options22.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat2));

            LatLng location23 = new LatLng(48.930475, 25.180383);
            MarkerOptions options23 = new MarkerOptions();
            options23.position(location23);
            options23.title("Палац Бадені");
            options23.snippet("");
            options23.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat2));

            LatLng location24 = new LatLng(51.641451, 33.061453);
            MarkerOptions options24 = new MarkerOptions();
            options24.position(location24);
            options24.title("Палац Рум'янцева-Задунайського");
            options24.snippet("");
            options24.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat2));

            LatLng location25 = new LatLng(50.836726, 32.655405);
            MarkerOptions options25 = new MarkerOptions();
            options25.position(location25);
            options25.title("Качанівський палац");
            options25.snippet("");
            options25.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat2));

            LatLng location26 = new LatLng(50.695403, 32.768108);
            MarkerOptions options26 = new MarkerOptions();
            options26.position(location26);
            options26.title("Палац Галаганів");
            options26.snippet("");
            options26.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat2));

            LatLng location27 = new LatLng(50.144076, 25.732713);
            MarkerOptions options27 = new MarkerOptions();
            options27.position(location27);
            options27.title("Білокриницький палац");
            options27.snippet("");
            options27.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat2));

            LatLng location28 = new LatLng(50.016035, 29.023243);
            MarkerOptions options28 = new MarkerOptions();
            options28.position(location28);
            options28.title("Пала́ц Бержи́нських-Тере́щенків");
            options28.snippet("");
            options28.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat2));

            LatLng location29 = new LatLng(51.334849, 32.893593);
            MarkerOptions options29 = new MarkerOptions();
            options29.position(location29);
            options29.title("Палац Розумовського");
            options29.snippet("");
            options29.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat2));

            LatLng location210 = new LatLng(50.20259394465113, 29.827446915372544);
            MarkerOptions options210 = new MarkerOptions();
            options210.position(location210);
            options210.title("Палац Хоєцьких");
            options210.snippet("");
            options210.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat2));

            LatLng location211 = new LatLng(48.87250352727883, 30.697272827376754);
            MarkerOptions options211 = new MarkerOptions();
            options211.position(location211);
            options211.title("Палац Шувалова");
            options211.snippet("");
            options211.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat2));


            LatLng location31 = new LatLng(48.734514, 25.637307);
            MarkerOptions options31 = new MarkerOptions();
            options31.position(location31);
            options31.title("Дністровський каньйон");
            options31.snippet("");
            options31.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat3_2));

            LatLng location32 = new LatLng(46.598303, 33.031973);
            MarkerOptions options32 = new MarkerOptions();
            options32.position(location32);
            options32.title("Олешківські піски");
            options32.snippet("");
            options32.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat3_2));

            LatLng location33 = new LatLng(50.314986, 29.093378);
            MarkerOptions options33 = new MarkerOptions();
            options33.position(location33);
            options33.title("Коростишівський каньйон");
            options33.snippet("");
            options33.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat3_2));

            LatLng location34 = new LatLng(48.804982, 25.587736);
            MarkerOptions options34 = new MarkerOptions();
            options34.position(location34);
            options34.title("Водоспад Джурин");
            options34.snippet("");
            options34.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat3_2));

            LatLng location35 = new LatLng(48.788857, 25.871526);
            MarkerOptions options35 = new MarkerOptions();
            options35.position(location35);
            options35.title("Печера Ветреба");
            options35.snippet("");
            options35.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat3_2));

            LatLng location36 = new LatLng(51.552701, 27.378903);
            MarkerOptions options36 = new MarkerOptions();
            options36.position(location36);
            options36.title("Юзефінськй дуб");
            options36.snippet("");
            options36.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat3_2));

            LatLng location37 = new LatLng(50.185201, 30.401181);
            MarkerOptions options37 = new MarkerOptions();
            options37.position(location37);
            options37.title("Васильківські карпати");
            options37.snippet("");
            options37.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat3_2));

            LatLng location38 = new LatLng(50.107325, 30.887347);
            MarkerOptions options38 = new MarkerOptions();
            options38.position(location38);
            options38.title("Витачів");
            options38.snippet("");
            options38.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat3_2));

            LatLng location39 = new LatLng(48.80334695451263, 27.0064909333546);
            MarkerOptions options39 = new MarkerOptions();
            options39.position(location39);
            options39.title("Водоспад Бурбун");
            options39.snippet("");
            options39.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat3_2));

            LatLng location310 = new LatLng(51.45406528460364, 24.38522192631205);
            MarkerOptions options310 = new MarkerOptions();
            options310.position(location310);
            options310.title("Семенова гора");
            options310.snippet("");
            options310.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat3_2));

            LatLng location311 = new LatLng(49.094615265962055, 30.397168505046466);
            MarkerOptions options311 = new MarkerOptions();
            options311.position(location311);
            options311.title("Буцький каньйон");
            options311.snippet("");
            options311.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat3_2));

            LatLng location312 = new LatLng(46.01539851621289, 30.39266314535958);
            MarkerOptions options312 = new MarkerOptions();
            options312.position(location312);
            options312.title("Будацька коса");
            options312.snippet("");
            options312.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat3_2));

            LatLng location41 = new LatLng(50.280283, 30.450634);
            MarkerOptions options41 = new MarkerOptions();
            options41.position(location41);
            options41.title("Змієві вали");
            options41.snippet("");
            options41.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat4));

            LatLng location42 = new LatLng(547.963003, 24.187597);
            MarkerOptions options42 = new MarkerOptions();
            options42.position(location42);
            options42.title("Географічний центр Європи");
            options42.snippet("");
            options42.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat4));

            LatLng location43 = new LatLng(48.633315, 25.746181);
            MarkerOptions options43 = new MarkerOptions();
            options43.position(location43);
            options43.title("Панорама на Заліщики");
            options43.snippet("");
            options43.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat4));

            LatLng location44 = new LatLng(50.750532, 26.043718);
            MarkerOptions options44 = new MarkerOptions();
            options44.position(location44);
            options44.title("Клеваньський тунель кохання");
            options44.snippet("");
            options44.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat4));

            LatLng location45 = new LatLng(50.934083, 31.697659);
            MarkerOptions options45 = new MarkerOptions();
            options45.position(location45);
            options45.title("Носівська станція");
            options45.snippet("");
            options45.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat4));

            LatLng location46 = new LatLng(49.288914, 25.713247);
            MarkerOptions options46 = new MarkerOptions();
            options46.position(location46);
            options46.title("Плебанівський віадук");
            options46.snippet("");
            options46.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat4));

            LatLng location47 = new LatLng(50.103048, 25.702074);
            MarkerOptions options47 = new MarkerOptions();
            options47.position(location47);
            options47.title("Санно-бобслейна траса");
            options47.snippet("");
            options47.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat4));

            LatLng location48 = new LatLng(50.21821667705015, 30.756093005553858);
            MarkerOptions options48 = new MarkerOptions();
            options48.position(location48);
            options48.title("Кийлівська дамба");
            options48.snippet("");
            options48.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat4));

            LatLng location49 = new LatLng(50.039898353028846, 28.683668844136278);
            MarkerOptions options49 = new MarkerOptions();
            options49.position(location49);
            options49.title("Будиночок рибалки на острові кохання");
            options49.snippet("");
            options49.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat4));

            LatLng location410 = new LatLng(50.36877508759842, 29.1931587769486);
            MarkerOptions options410 = new MarkerOptions();
            options410.position(location410);
            options410.title("Кар'єр Високий камінь");
            options410.snippet("");
            options410.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat4));

            LatLng location411 = new LatLng(50.103048, 25.702074);
            MarkerOptions options411 = new MarkerOptions();
            options411.position(location411);
            options411.title("Легедзине");
            options411.snippet("");
            options411.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat4));

            LatLng location51 = new LatLng(50.005144, 25.507038);
            MarkerOptions options51 = new MarkerOptions();
            options51.position(location51);
            options51.title("Почаївська Успенська лавра");
            options51.snippet("");
            options51.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat5_church));

            LatLng location52 = new LatLng(50.103090, 28.948340);
            MarkerOptions options52 = new MarkerOptions();
            options52.position(location52);
            options52.title("Костел Антонія Падуанського");
            options52.snippet("");
            options52.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat5_church));

            LatLng location53 = new LatLng(50.096220, 25.724329);
            MarkerOptions options53 = new MarkerOptions();
            options53.position(location53);
            options53.title("Єзуїтський колегіум");
            options53.snippet("");
            options53.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat5_church));

            LatLng location54 = new LatLng(49.899014, 28.983845);
            MarkerOptions options54 = new MarkerOptions();
            options54.position(location54);
            options54.title("Костел Святої Клари");
            options54.snippet("");
            options54.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat5_church));

            LatLng location55 = new LatLng(49.939424, 24.983961);
            MarkerOptions options55 = new MarkerOptions();
            options55.position(location55);
            options55.title("Костел в Підгірцях");
            options55.snippet("");
            options55.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat5_church));

            LatLng location56 = new LatLng(49.897565, 28.574375);
            MarkerOptions options56 = new MarkerOptions();
            options56.position(location56);
            options56.title("Монастир Кармелітів Босих");
            options56.snippet("");
            options56.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat5_church));

            LatLng location57 = new LatLng(49.37279067822557, 29.67782983218802);
            MarkerOptions options57 = new MarkerOptions();
            options57.position(location57);
            options57.title("Каплиця Свейковських");
            options57.snippet("");
            options57.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat5_church));

            LatLng location58 = new LatLng(51.47782782957101, 31.284409485260475);
            MarkerOptions options58 = new MarkerOptions();
            options58.position(location58);
            options58.title("Антонієві печери");
            options58.snippet("");
            options58.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat5_church));

            LatLng location59 = new LatLng(50.87614561172971, 31.179537653400573);
            MarkerOptions options59 = new MarkerOptions();
            options59.position(location59);
            options59.title("Храм св. Георгія в с. Данівка");
            options59.snippet("");
            options59.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat5_church));

            LatLng location510 = new LatLng(50.99564536451878, 31.139426959532155);
            MarkerOptions options510 = new MarkerOptions();
            options510.position(location510);
            options510.title("Трьохсвятительська церква с. Лемеші");
            options510.snippet("");
            options510.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat5_church));

            LatLng location511 = new LatLng(51.5543161844238, 32.01498016622743);
            MarkerOptions options511 = new MarkerOptions();
            options511.position(location511);
            options511.title("Церква Успіння Пресвятої Богородиці с. Волосківці");
            options511.snippet("");
            options511.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat5_church));

            LatLng location512 = new LatLng(51.52627585763449, 32.03219916482482);
            MarkerOptions options512 = new MarkerOptions();
            options512.position(location512);
            options512.title("Храм Пресвятої Трійці с. Степанівка");
            options512.snippet("");
            options512.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat5_church));

            LatLng location513 = new LatLng(51.607916516621465, 32.0129961079719);
            MarkerOptions options513 = new MarkerOptions();
            options513.position(location513);
            options513.title("Козацька Покровська церква с. Синявка");
            options513.snippet("");
            options513.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat5_church));

            LatLng location514 = new LatLng(50.63642703610482, 32.47467090052784);
            MarkerOptions options514 = new MarkerOptions();
            options514.position(location514);
            options514.title("Густинський Свято-Троїцький монастир");
            options514.snippet("");
            options514.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat5_church));

            LatLng location515 = new LatLng(48.5956839824458, 27.322064671081385);
            MarkerOptions options515 = new MarkerOptions();
            options515.position(location515);
            options515.title("Скельний монастир Галиця");
            options515.snippet("");
            options515.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat5_church));

            LatLng location61 = new LatLng(49.966383, 31.391249);
            MarkerOptions options61 = new MarkerOptions();
            options61.position(location61);
            options61.title("Парк Трахтемирів");
            options61.snippet("");
            options61.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat6_park));

            LatLng location62 = new LatLng(48.756690, 30.235681);
            MarkerOptions options62 = new MarkerOptions();
            options62.position(location62);
            options62.title("Софіївський парк");
            options62.snippet("");
            options62.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat6_park));

            LatLng location63 = new LatLng(48.990177, 38.240181);
            MarkerOptions options63 = new MarkerOptions();
            options63.position(location63);
            options63.title("Кремінські ліси");
            options63.snippet("");
            options63.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat6_park));

            LatLng location64 = new LatLng(50.89526551622905, 30.871761699506873);
            MarkerOptions options64 = new MarkerOptions();
            options64.position(location64);
            options64.title("Парк природи 'Беремицьке'");
            options64.snippet("");
            options64.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat6_park));

            LatLng location65 = new LatLng(49.83921518372384, 29.65956026530128);
            MarkerOptions options65 = new MarkerOptions();
            options65.position(location65);
            options65.title("Ландшафтний парк Буки");
            options65.snippet("");
            options65.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat6_park));

            LatLng location66 = new LatLng(50.41963638507429, 29.93558561291829);
            MarkerOptions options66 = new MarkerOptions();
            options66.position(location66);
            options66.title("Добропарк");
            options66.snippet("");
            options66.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat6_park));

            LatLng location67 = new LatLng(49.81462838628894, 30.078145078222242);
            MarkerOptions options67 = new MarkerOptions();
            options67.position(location67);
            options67.title("Олександрія");
            options67.snippet("");
            options67.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat6_park));

            LatLng location68 = new LatLng(50.78747180957767, 32.81514951118296);
            MarkerOptions options68 = new MarkerOptions();
            options68.position(location68);
            options68.title("Тростянецький парк");
            options68.snippet("");
            options68.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat6_park));

            LatLng location71 = new LatLng(50.409155, 29.891771);
            MarkerOptions options71 = new MarkerOptions();
            options71.position(location71);
            options71.title("Маєток фон Мекк");
            options71.snippet("");
            options71.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat7));

            LatLng location72 = new LatLng(49.228644, 29.352672);
            MarkerOptions options72 = new MarkerOptions();
            options72.position(location72);
            options72.title("Садиба Заботіна");
            options72.snippet("");
            options72.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat7));

            LatLng location73 = new LatLng(50.752796, 31.409742);
            MarkerOptions options73 = new MarkerOptions();
            options73.position(location73);
            options73.title("Садиба Катериничів");
            options73.snippet("");
            options73.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat7));

            LatLng location74 = new LatLng(50.612226, 30.474188);
            MarkerOptions options74 = new MarkerOptions();
            options74.position(location74);
            options74.title("Межигір'я");
            options74.snippet("");
            options74.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat7));

            LatLng location75 = new LatLng(51.09856744191788, 31.207994226997933);
            MarkerOptions options75 = new MarkerOptions();
            options75.position(location75);
            options75.title("Маєток Пашковських");
            options75.snippet("");
            options75.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat7));

            LatLng location81 = new LatLng(50.101062, 25.728370);
            MarkerOptions options81 = new MarkerOptions();
            options81.position(location81);
            options81.title("Кременець");
            options81.snippet("");
            options81.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat8));

            LatLng location82 = new LatLng(49.062785, 25.408508);
            MarkerOptions options82 = new MarkerOptions();
            options82.position(location82);
            options82.title("Бучач");
            options82.snippet("");
            options82.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat8));

            LatLng location83 = new LatLng(50.179605, 27.066903);
            MarkerOptions options83 = new MarkerOptions();
            options83.position(location83);
            options83.title("Шепетівка");
            options83.snippet("");
            options83.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat8));

            LatLng location84 = new LatLng(50.0726194198871, 31.462253337585732);
            MarkerOptions options84 = new MarkerOptions();
            options84.position(location84);
            options84.title("Переяслав");
            options84.snippet("");
            options84.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat8));

            LatLng location85 = new LatLng(49.802694320453575, 30.124086285391016);
            MarkerOptions options85 = new MarkerOptions();
            options85.position(location85);
            options85.title("Біла Церква");
            options85.snippet("");
            options85.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat8));

            LatLng location86 = new LatLng(50.91333336318149, 31.117014318186854);
            MarkerOptions options86 = new MarkerOptions();
            options86.position(location86);
            options86.title("Козелець");
            options86.snippet("");
            options86.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat8));

            LatLng location87 = new LatLng(51.64138787051289, 31.566096871406486);
            MarkerOptions options87 = new MarkerOptions();
            options87.position(location87);
            options87.title("Седнів");
            options87.snippet("");
            options87.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat8));

            LatLng location88 = new LatLng(50.59331858046965, 32.38731249048542);
            MarkerOptions options88 = new MarkerOptions();
            options88.position(location88);
            options88.title("Прилуки");
            options88.snippet("");
            options88.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat8));

            LatLng location89 = new LatLng(51.56863763825095, 32.954674879657794);
            MarkerOptions options89 = new MarkerOptions();
            options89.position(location89);
            options89.title("Короп");
            options89.snippet("");
            options89.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat8));

            LatLng location810 = new LatLng(52.012780613287305, 33.26249187988585);
            MarkerOptions options810 = new MarkerOptions();
            options810.position(location810);
            options810.title("Новгород-Сіверський");
            options810.snippet("");
            options810.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cat8));

            //move camera to start position
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(location29, +5));
            //map.setOnInfoWindowClickListener(googleMap);
            map.addMarker(options11);
            map.addMarker(options12);
            map.addMarker(options13);
            map.addMarker(options14);
            map.addMarker(options15);
            map.addMarker(options16);
            map.addMarker(options17);
            map.addMarker(options18);
            map.addMarker(options19);
            map.addMarker(options110);
            map.addMarker(options111);
            map.addMarker(options112);
            map.addMarker(options113);
            map.addMarker(options21);
            map.addMarker(options22);
            map.addMarker(options23);
            map.addMarker(options24);
            map.addMarker(options25);
            map.addMarker(options26);
            map.addMarker(options27);
            map.addMarker(options28);
            map.addMarker(options29);
            map.addMarker(options210);
            map.addMarker(options211);
            map.addMarker(options31);
            map.addMarker(options32);
            map.addMarker(options33);
            map.addMarker(options34);
            map.addMarker(options35);
            map.addMarker(options36);
            map.addMarker(options37);
            map.addMarker(options38);
            map.addMarker(options39);
            map.addMarker(options310);
            map.addMarker(options311);
            map.addMarker(options312);
            map.addMarker(options41);
            map.addMarker(options42);
            map.addMarker(options43);
            map.addMarker(options44);
            map.addMarker(options45);
            map.addMarker(options46);
            map.addMarker(options47);
            map.addMarker(options48);
            map.addMarker(options49);
            map.addMarker(options410);
            map.addMarker(options411);
            map.addMarker(options51);
            map.addMarker(options52);
            map.addMarker(options53);
            map.addMarker(options54);
            map.addMarker(options55);
            map.addMarker(options56);
            map.addMarker(options57);
            map.addMarker(options58);
            map.addMarker(options59);
            map.addMarker(options510);
            map.addMarker(options511);
            map.addMarker(options512);
            map.addMarker(options513);
            map.addMarker(options514);
            map.addMarker(options515);
            map.addMarker(options61);
            map.addMarker(options62);
            map.addMarker(options63);
            map.addMarker(options64);
            map.addMarker(options65);
            map.addMarker(options66);
            map.addMarker(options67);
            map.addMarker(options68);
            map.addMarker(options71);
            map.addMarker(options72);
            map.addMarker(options73);
            map.addMarker(options81);
            map.addMarker(options82);
            map.addMarker(options83);
            map.addMarker(options84);
            map.addMarker(options85);
            map.addMarker(options86);
            map.addMarker(options87);
            map.addMarker(options88);
            map.addMarker(options89);
            map.addMarker(options810);

        }

    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        //Toast.makeText(getContext(), "POp", Toast.LENGTH_SHORT).show();

    }
}