package com.example.febrezemobileapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.febrezemobileapp.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private String[] announcementModel = {"4 Mayıs Dünya Çiçek Günü “DOĞADAN BİRER PARÇA”Etkinliği",
        "İstanbul/Beykoz Lions Barış Ormanı Lavanta Ekimi", "İstanbul-Ankara-İzmir Simülasyon Etkinliği",
        "İstanbul-Ankara-İzmir Koku Bilmece Etkinliği", "Ezgi Mola ve Kadir Ezildi ile BKM Söyleşi Etkinliği",
        "Febreze Parfüm Dağıtımı 'EN SAFLARIN SENTEZİ'", "Toplu Taşıma Araçları’na Febreze Otomatları Yerleştirme",
        "Febreze 10 Doğa Harikası, Şehir Turu 'DOĞALA YOLCULUK'"
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        ListView view = (ListView) root.findViewById(R.id.lvMainMenu);
        view.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_expandable_list_item_1, announcementModel));


        return root;
    }
}