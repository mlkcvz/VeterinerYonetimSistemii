# 🐾 Veterinary Management System - Java Spring Boot Bitirme Projesi

Bu proje, bir veteriner kliniğinin hasta (hayvan), müşteri (sahip), veteriner hekim, aşı ve randevu süreçlerini dijital ortamda yönetmesini sağlayan bir **RESTful API** çözümüdür. Proje, Spring Boot framework'ü ile katmanlı mimariye uygun şekilde geliştirilmiştir.
UML 
![image](https://github.com/user-attachments/assets/cada7b41-f988-4032-8c77-91cf69a57886)

---

## 📦 Proje Özeti

| Alan                  | Detay                                     |
|-----------------------|--------------------------------------------|
| **Dil**               | Java 17                                    |
| **Framework**         | Spring Boot                                |
| **Veritabanı**        | PostgreSQL                                 |
| **Mimari**            | Katmanlı Mimari (Controller, Service, Repo, DTO) |
| **DTO & Mapping**     | Request/Response DTO + ModelMapper         |
| **Bağımlılıklar**     | Spring Data JPA, Lombok, ModelMapper       |
| **Test**              | Postman Collection (Proje ile birlikte)    |

---

🔧 Proje Özellikleri
🧍‍♂️ Müşteri Yönetimi (/api/customers)
Müşteri oluştur / sil / listele / güncelle

İsme göre arama (query param)

🐶 Hayvan Yönetimi (/api/animals)
Hayvan ekleme / silme / güncelleme

İsme göre filtreleme

Müşteri ID’ye göre hayvanları listeleme

💉 Aşı Yönetimi (/api/vaccines)
Aşı ekleme, silme, listeleme

Aynı hayvana aynı aşı bitmeden tekrar uygulanamaz

Tarih aralığına göre koruma süresi yaklaşanları listeleme

🩺 Veteriner Doktor Yönetimi (/api/doctors)
Doktor ekleme, silme, güncelleme, listeleme

📅 Çalışma Günleri (/api/doctors/{id}/available-dates)
Doktorların müsait günlerini yönet

📆 Randevu Yönetimi (/api/appointments)
Randevu oluşturma, silme, listeleme

Tarih+Saat çakışma kontrolü yapılır

Doktorun o gün çalışıp çalışmadığı kontrol edilir

Doktora ve hayvana göre tarih aralığında filtreleme yapılabilir

⚠️ Exception & Validasyonlar
Durum	Mesaj
Aynı kayıt tekrar eklenirse	AlreadyExistsException
ID bulunamazsa	NotFoundException
Randevu çakışması varsa	"Girilen saatte başka bir randevu mevcuttur"
Doktor o gün çalışmıyorsa	"Doktor bu tarihte çalışmamaktadır"

Tüm istisnalar global olarak GlobalExceptionHandler üzerinden yönetilir. 

POST http://localhost:8080/api/customers
Body (JSON):
{
  "name": "Ahmet Yılmaz",
  "phone": "05554443322",
  "mail": "ahmet@mail.com",
  "address": "Beşiktaş",
  "city": "İstanbul"
}
✅ Hayvan Ekleme (POST)
bash
Kopyala
Düzenle
POST http://localhost:8080/api/animals
Body:
{
  "name": "Karabaş",
  "species": "Köpek",
  "breed": "Golden",
  "gender": "Erkek",
  "colour": "Sarı",
  "dateOfBirth": "2021-03-01",
  "customerId": 1
}
✅ Aşı Ekleme
bash
Kopyala
Düzenle
POST http://localhost:8080/api/vaccines
{
  "name": "Kuduz",
  "code": "RAB-01",
  "protectionStartDate": "2025-06-01",
  "protectionFinishDate": "2026-06-01",
  "animalId": 1
}
✅ Randevu Ekleme
bash
Kopyala
Düzenle
POST http://localhost:8080/api/appointments
{
  "appointmentDate": "2025-07-15T14:00:00",
  "doctorId": 1,
  "animalId": 1
}

