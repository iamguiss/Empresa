package br.com.etecia.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class calculatorActivity extends AppCompatActivity {

    public class Calcular{
        private double txtValorEnter;
        private double valorporcentagem;

        public Calcular (double txtValorEnter, double valorporcentagem){
            this.txtValorEnter=txtValorEnter;
            this.valorporcentagem=valorporcentagem;
        }

        public double calcularTipo() {
            return(txtValorEnter * valorporcentagem / 100);
        }

        public double calcularTotal(){
            return txtValorEnter + calcularTipo();
        }

        public double getTxtValorEnter(){
            return txtValorEnter;
        }
        public void setTxtValorEnter(double txtValorEnter){
            this.txtValorEnter = txtValorEnter;
        }

        public double getValorporcentagem(){
            return valorporcentagem;
        }

        public void setValorporcentagem(double valorporcentagem){
            this.valorporcentagem = valorporcentagem;
        }
    }

    public class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);
    }
}