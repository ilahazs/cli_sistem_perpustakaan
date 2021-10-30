package com.perpustakaan;

class Siswa {
   String nama, kelas, jurusan, NIS;
   int usia;
   // boolean status = false;
   KeAnggotan anggota;

   Siswa(String nama, String kelas, String jurusan, String NIS) {
      this.nama = nama;
      this.kelas = kelas;
      this.jurusan = jurusan;
      this.NIS = NIS;
   }

   void profile() {
      // String statusAnggota = (this.status == true ? "terdaftar" : "blm terdaftar");
      System.out.println("\nPROFILE\n========================\n");
      System.out.printf("Nama       : %s\n", this.nama);
      System.out.printf("Kelas      : %s\n", this.kelas);
      System.out.printf("Jurusan    : %s\n", this.jurusan);
      System.out.printf("NIS        : %s\n", this.NIS);
      System.out.printf("Anggota    : %s\n", this.anggota.getStatus());
      System.out.println("\n========================");
   }

   void daftarAnggota(KeAnggotan anggota) {
      this.anggota = anggota;
      this.anggota.status = true;
   }

}

// Class lain
class KeAnggotan {
   int UID = 0;
   boolean status = false;
   String nama, NIS;

   KeAnggotan(Siswa siswa) {
      this.nama = siswa.nama;
      this.UID += 1;
      this.NIS = siswa.NIS;
   }

   boolean getStatus() {
      return this.status;
   }

   void pinjamBuku(Buku buku) {
      buku.stock -= 1;
   }

   void kembalikanBuku(Buku buku) {
      buku.stock += 1;
      // if buku.stock
   }
}

class Buku {
   String judul, penulis;
   int jumlah_halaman, stock;

   Buku(String judul, String penulis, int jumlah_halaman, int stock) {
      this.judul = judul;
      this.penulis = penulis;
      this.jumlah_halaman = jumlah_halaman;
      this.stock = stock;
   }

   void show() {
      // String statusAnggota = (this.status == true ? "terdaftar" : "blm terdaftar");
      System.out.println("\nDETAIL BUKU\n========================\n");
      System.out.printf("Judul    : %s\n", this.judul);
      System.out.printf("Penulis  : %s\n", this.penulis);
      System.out.printf("Hal      : %s\n", this.jumlah_halaman + " hal");
      System.out.printf("Stock    : %s\n", this.stock + " item");
      System.out.println("\n========================");
   }

}

public class Main {
   public static void main(String[] args) {
      Siswa siswa1 = new Siswa("Ilahazs", "XII", "RPL", "1920118111");
      Siswa siswa2 = new Siswa("DIO", "XII", "TKJ", "1920118100");
      // new KeAnggotan(siswa1);
      siswa1.daftarAnggota(new KeAnggotan(siswa1));
      siswa2.daftarAnggota(new KeAnggotan(siswa2));
      // siswa1.profile();

      // EKSEKUSI BUKU
      Buku buku1 = new Buku("Ksatria Batman", "Diluc", 25, 10);
      buku1.show();
      siswa1.anggota.pinjamBuku(buku1);
      buku1.show();
      siswa1.anggota.kembalikanBuku(buku1);
      buku1.show();

      // System.out.println(siswa1.anggota.UID);
      // System.out.println(siswa2.anggota.UID);
   }
}