package com.biopic.movieexplorer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList

@Composable
fun rememberMovies() : SnapshotStateList<Movie>{
    val movieList = remember {
        mutableStateListOf(
            Movie(
                1,
                R.drawable.movie1,
                "Azaan Sami Khan - Ik Lamha ft. Maya Ali (Official Music Video)",
                "03:33"
            ),
            Movie(
                2,
                R.drawable.movie2,
                "Bulleya - Lyrical Video | Ae Dil Hai Mushkil | Amit Mishra, Shilpa Rao | Pritam",
                "01:14:43"
            ),
            Movie(
                3,
                R.drawable.movie3,
                "Gehra Hua - Surround Sound | Dhurandhar | Ranveer Singh, Sara Arjun, Shashwat Sachdev, Arijit Singh",
                "23:25"
            ),
            Movie(
                4,
                R.drawable.movie4,
                "Phir Se - Dolby Atmos | Dhurandhar The Revenge | Ranveer Singh, Sara Arjun, Shashwat Sachdev, Arijit Singh",
                "02:56"
            ),
            Movie(
                5,
                R.drawable.movie5,
                "Dil Karo Asambhav - Surround Sound | Mission Majnu | Sidharth Malhotra, Rashmika Mandanna, Tanishk Bagchi, Rochak Kohli",
                "04:56"
            ),
            Movie(
                6,
                R.drawable.movie6,
                "Dil Diya Gallan - Spatial Audio | Tiger Zinda Hai | Salman Khan, Katrina Kaif, Vishal-Shekhar, Atif Aslam",
                "07:26"
            ),
            Movie(
                7,
                R.drawable.movie7,
                "Besharam Rang - Bass Boosted | Pathaan | Shah Rukh Khan, Deepika Padukone, Vishal-Shekhar, Shilpa Rao",
                "08:33"
            ),
            Movie(
                8,
                R.drawable.movie18,
                "Ae Watan - Surround Sound | Raazi | Alia Bhatt, Vicky Kaushal, Shankar-Ehsaan-Loy, Arijit Singh",
                "01:26"
            ),
            Movie(
                9,
                R.drawable.movie9,
                "Tu Hi Hai - High Definition | D-Day | Arjun Rampal, Huma Qureshi, Shankar-Ehsaan-Loy, Rekha Bhardwaj",
                "02:16"
            ),
            Movie(
                10,
                R.drawable.movie10,
                "Challa (Main Lad Jaana) - IMAX Audio | Uri: The Surgical Strike | Vicky Kaushal, Yami Gautam, Shashwat Sachdev, Romy",
                "03:44:12"
            ),
            Movie(
                11,
                R.drawable.movie11,
                "Hukum (Thalaivar Alappara) - Dolby Atmos | Jailer | Rajinikanth, Tamannaah Bhatia, Anirudh Ravichander",
                "03:36"
            ),
            Movie(
                12,
                R.drawable.movie12,
                "Wala Sanda - Bass Boosted | Vikram | Kamal Haasan, Vijay Sethupathi, Fahadh Faasil, Anirudh Ravichander",
                "41:10:07"
            ),
            Movie(
                13,
                R.drawable.movie13,
                "Sauda - Spatial Audio | Madras Cafe | John Abraham, Nargis Fakhri, Shantanu Moitra, Papon",
                "02:06"
            ),
            Movie(
                14,
                R.drawable.movie14,
                "Zinda - Surround Sound | Bhaag Milkha Bhaag | Farhan Akhtar, Sonam Kapoor, Shankar-Ehsaan-Loy, Siddharth Mahadevan",
                "05:08"
            ),
            Movie(
                15,
                R.drawable.movie15,
                "Ishq Jalakar (Karvaan) - Dolby Digital | Dhurandhar | Ranveer Singh, Sanjay Dutt, Shashwat Sachdev, Hanumankind",
                "10:02"
            ),
            Movie(
                16,
                R.drawable.movie16,
                "Pee Loon - Surround Sound | Once Upon a Time in Mumbaai | Ajay Devgn, Emraan Hashmi, Pritam, Mohit Chauhan",
                "00:26"
            ),
            Movie(
                17,
                R.drawable.movie17,
                "O Meri Jaan - High Definition | Life in a... Metro | Kangana Ranaut, Sharman Joshi, Pritam, KK",
                "02:04"
            ),
            Movie(
                18,
                R.drawable.movie19,
                "Jiya Tu Bihar Ke Lala - Spatial Audio | Gangs of Wasseypur | Manoj Bajpayee, Nawazuddin Siddiqui, Sneha Khanwalkar, Manoj Tiwari",
                "02:56:08"
            ),
            Movie(
                19,
                R.drawable.movie20,
                "Aala Re Aala - Bass Boosted | Shootout at Wadala | John Abraham, Anil Kapoor, Anu Malik, Mika Singh",
                "09:11"
            )
        )
    }
    return movieList
}