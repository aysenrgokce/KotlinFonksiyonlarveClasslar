package com.aysenurgokce.kotlinclassesandfunctions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // class level'da myTextView tanımlandı
    lateinit var myTextView: TextView
    private lateinit var nameText: EditText
    private lateinit var ageText: EditText
    private lateinit var jobText: EditText


    lateinit var myButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // onCreate içinde initialize ediliyor
        myTextView = findViewById(R.id.textView)
        myButton = findViewById(R.id.button)
        nameText = findViewById(R.id.nameText)
        ageText = findViewById(R.id.ageText)
        jobText = findViewById(R.id.jobText)
        var name =" "





        /*buttona onclicked değeri eklemezsem bu tarz bir ekleme yöntemi yapabilirim
        myButton.setOnClickListener {
        myTextView.text= "Button clicked 2 " }
        */



        selamVer()

        val sonuc = topla(3, 5)
        println("Sonuç: $sonuc")

        selamVer() // Çıktı: Merhaba, Ziyaretçi!
        selamVer("Ali") // Çıktı: Merhaba, Ali!

        val uzunluk = metinUzunlugu("Kotlin")
        println("Metin uzunluğu: $uzunluk") // Çıktı: Metin uzunluğu: 6

        val result = mySum(36, 29)
        println(result)

        //Sınıf Yapısı- sınıf yapısını kullanırken
        var homer = Simpson("homer", 50,"Nuclear" )
        homer.name="Homer Simson "

        println(homer.name)


        //Nullability
        var myString :  String? = null//? null olabilir demek
        myString = "Ayşenur"
        println(myString)

        //1) Not-null Assertion Operatörü (!!)
        //Eğer bir nullable değişkenin kesinlikle null olmayacağından eminseniz !! kullanabilirsiniz. Ancak bu değişken null olursa NullPointerException fırlatılır.
        var myAge : Int? = null
        //myAge = 50
        //println(myAge!! * 10)//

        //2) safe call
        //println(myAge.minus(10))

        //3)
        if(myAge != null){
            println(myAge.minus(10))
        }else{
            println("myAge is null ")
        }

        //4)Elvis operatörü (?:)
        println(myAge?.minus(10) ?: -10)//eğer null değeri gelirse -10 değerini yazdır


        myAge?.let {
            println(it * 10)// eğer nullsa burası çalışmaz
        }


    }

    // Fonksiyonlar

    fun selamVer() {
        //println("Merhaba, Kotlin!")
    }

    fun topla(a: Int, b: Int): Int {
        return a + b
    }

    fun selamVer(isim: String = "Ziyaretçi") {
       // println("Merhaba, $isim!")
    }

    fun metinUzunlugu(metin: String): Int {
        return metin.length
    }

    fun mySum(a: Int, b: Int) {
        myTextView.text = "Result : ${a + b}"
    }

    fun buttonClicked(view: View) {
        name = nameText.text.toString()
        val age = ageText.text.toString().toIntOrNull()
        val job  =jobText.text.toString()

        if(age != null){
            val simpson =Simpson(name,age ,job)
            myTextView.text = "Name: ${simpson.name}  Age: ${simpson.age}  Job: ${simpson.job}}"
        }else{
            myTextView.text = "Enter your age!"
        }
    }

    //ERİŞİM BELİRLEYİCİLER
    /*  public -> Varsayılan erişim türü -> Tüm modüllerden ve dışarıdan erişilebilir.
        internal -> Aynı modüldeki sınıflardan erişilebilir -> Yalnızca aynı modüldeki sınıflardan erişilebilir.
        protected -> Sınıf ve türetilmiş sınıflardan erişilebilir -> Sınıf ve alt sınıflardan erişilebilir.
        private -> Yalnızca sınıf içinde erişilebilir -> Sadece tanımlandığı sınıf içinde erişilebilir.
        local -> Yerel değişkenler için geçerlidir -> Lambdada veya fonksiyon içinde tanımlandığı yerel alanlarda erişilebilir.*/


    //Nullable Nedir->Kotlin'de nullable terimi, bir değişkenin veya nesnenin null değerini alabilmesi anlamına gelir. Yani, bir değişkenin null olmasına izin veriliyorsa, bu değişken nullable olarak tanımlanır.
    //Kotlin'de nullable türler, değişkenin tipinin sonuna ? eklenerek belirtilir

    var name: String = "John" // Bu, null olmayan bir String
    var nullableName: String? = null // Bu, null olabilen bir String






}
