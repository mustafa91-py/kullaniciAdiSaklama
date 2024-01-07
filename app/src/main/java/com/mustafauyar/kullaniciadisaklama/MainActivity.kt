package com.mustafauyar.kullaniciadisaklama
import com.mustafauyar.kullaniciadisaklama.databinding.ActivityMainBinding

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

/*
bu derste küçük verileri nasıl kaydediriz ve geri alırız ondan behsedildi
SharedPreferences sınıfı kullandı
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences //  xml dosyası için referans
    var alinanKullaniciAdi :String ?= null//sınıf düzeyinde kaydedilen ismin yerini tutan değişken
    /*
    SharedPreferences xml dosyasına küçük veriler kaydetmek için ideal
    json dosyası gibi yani sözlük biçimi gibi kullanımı benzer

     */
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater) // widgetleri bağladım erişmek için
        setContentView(binding.root)
        sharedPreferences =this.getSharedPreferences("com.mustafauyar.kullaniciadisaklama",
        Context.MODE_PRIVATE) // dosyanın ismini yazdım ve modunu belirttim
        alinanKullaniciAdi = sharedPreferences.getString("kullanici","") // kaydedilen ismi al değişkene eşitle
        if (alinanKullaniciAdi != null ) { // eğer null değilse isimText e yaz
            binding.isimView.text = "son girilen kullanici adi : $alinanKullaniciAdi"
        }
     }
    fun kaydet(view: View){
        // kaydet butonuna basılnınca ne olacak fonksiyounu
        val kullaniciAdiAl = binding.isimText.text.toString()
        if (kullaniciAdiSorgula(kullaniciAdiAl)){ // isim boş mu değilmi fonksiyon ile kontrol
            sharedPreferences.edit().putString("kullanici",kullaniciAdiAl).apply()
            // eğer boş değilse xml dosyasının içine edit moduna girerek ekledim ve apply ederek kapattım
            binding.isimView.text = "kullanıcı adı : ${kullaniciAdiAl.uppercase()}"
            binding.isimView.textSize = 24f
            binding.isimView.setTextColor(Color.GREEN)
        }

    }
    fun sil (view: View){

    }
    fun kullaniciAdiSorgula(name:String?): Boolean {
        // eğer bir şeyi return ediyorsan döndürelecek şeyin ne olduğunu belirt fun da
        val toast_mesaj = Toast.makeText(this,"kullanici adi boş olamaz",
            Toast.LENGTH_LONG)
        if (name.isNullOrBlank()){//metin boş mu null mu yoksa boşluklardan mı oluşmuş kontrol et
            toast_mesaj.show() // boş olduğunu göster
            return false // boşsa false gönder
        } else {
            toast_mesaj.setText("başarılı") // isim varsa başarılı yaz
            toast_mesaj.show() // başarılıyı göster
            return true
        }
    }
}