# OOD-Practice-1-

<table dir="rtl">

<h2><b>گام اول: (افزودن دو قابلیت جدید)</b></h2>
<thead>
  <tr>
    <th align="center">ردیف</th>
    <th align="center">کلاس تغییر یافته (ارسال پیام)</th>
    <th align="center">توضیح کوتاه (ارسال پیام)</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td align="center">1</td>
    <td align="center">Message Sender</td>
    <td><div style="direction: rtl; text-align: right;">افزودن یک تابع برای ارسال پیامک به نام Send Sms </div></td>
  </tr>
  <tr>
    <td align="center">2</td>
    <td align="center">SmsSender</td>
    <td><div style="direction: rtl; text-align: right;">پیاده‌سازی متد جدید sendSms در کلاس جدید Sms Sender</div></td>
  </tr>
  <tr>
    <td align="center">3</td>
    <td align="center">SmsSender</td>
    <td><div style="direction: rtl; text-align: right;">افزودن کلاس SmsSender که واسط MessageSender را پیاده‌سازی کرده و متد sendSms را پیاده می‌کند.</div></td>
  </tr>
  <tr>
    <td align="center">4</td>
    <td align="center">ReservationService</td>
    <td><div style="direction: rtl; text-align: right;">افزودن case جدید در بلاک switch برای نوع اعلان Notifier.SMS و ایجاد شیء از SmsSender و فراخوانی sendSms.</div></td>
  </tr>
</tbody>
</table>








<table dir="rtl">
<thead>
  <tr>
    <th align="center">ردیف</th>
    <th align="center">کلاس تغییر یافته (پرداخت)</th>
    <th align="center">توضیح کوتاه (پرداخت)</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td align="center">1</td>
    <td align="center">PaymentProcessor</td>
    <td>
      <div style="direction: rtl; text-align: right;">
        افزودن یک تابع برای پرداخت حضوری به نام <b>onSitePayment</b>
      </div>
    </td>
  </tr>

  <tr>
    <td align="center">2</td>
    <td align="center">ReservationService</td>
    <td>
      <div style="direction: rtl; text-align: right;">
        افزودن <b>case</b> به دستور <b>switch</b> برای پرداخت حضوری
      </div>
    </td>
  </tr>
</tbody>
</table>



<div dir="rtl">

<h2><b>گام دوم: (تحلیل اصول شی‌گرایی)</b></h2>

<table>
  <tr>
    <th>اصل</th>
    <th>وضعیت</th>
    <th>کلاس</th>
    <th>جزئیات نقص/برقراری</th>
  </tr>

  <tr>
    <td>SRP</td>
    <td>مورد برقراری</td>
    <td>EmailSender.java</td>
    <td>هر کلاس تنها یک وظیفه مشخص (ارسال از طریق یک کانال) را انجام می‌دهد و تنها به یک دلیل برای تغییر نیاز دارد.</td>
  </tr>
  <tr>
    <td>SRP</td>
    <td>مورد نقص</td>
    <td>ReservationService.java</td>
    <td>
      حداقل ۴ مسئولیت متفاوت دارد: ۱. مدیریت جریان رزرو. ۲. اعمال منطق تخفیف (if شهر پاریس). ۳. اجرای منطق پرداخت (switch پرداخت). ۴. مدیریت منطق اعلان (switch نوتیفایر).
    </td>
  </tr>
  <tr>
    <td>SRP</td>
    <td>مورد نقص</td>
    <td>PaymentProcessor.java</td>
    <td>
      مسئولیت این کلاس، مدیریت انواع مختلف عملیات پرداخت (payByCard, payByCash, payByPayPal) است. این وظایف باید به کلاس‌های مخصوص به خود تفکیک شوند تا برای افزودن روش جدید، نیاز به تغییر کد در این کلاس نباشد.
    </td>
  </tr>

  <tr>
    <td>OCP</td>
    <td>مورد برقراری</td>
    <td>LuxuryRoom.java</td>
    <td>با ارث‌بری از Room و افزودن متد جدید (addFreeDinner)، کلاس برای توسعه باز است بدون اینکه نیاز به تغییر در کلاس والد داشته باشد.</td>
  </tr>
  <tr>
    <td>OCP</td>
    <td>مورد نقص</td>
    <td>ReservationService.java</td>
    <td>برای افزودن روش پرداخت جدید یا کانال اعلان جدید، باید کد اصلی makeReservation اصلاح شود (ویرایش بلوک‌های switch).</td>
  </tr>

  <tr>
    <td>LSP</td>
    <td>مورد برقراری</td>
    <td>LuxuryRoom.java</td>
    <td>زیرکلاس‌ها (LuxuryRoom) رفتار ناسازگاری با کلاس والد (Room) ندارند و می‌توانند بدون برهم زدن برنامه جایگزین Room شوند.</td>
  </tr>
  <tr>
    <td>LSP</td>
    <td>مورد نقص</td>
    <td>-</td>
    <td>نقص مستقیمی مشاهده نمی‌شود.</td>
  </tr>

  <tr>
    <td>ISP</td>
    <td>مورد نقص</td>
    <td>MessageSender.java</td>
    <td>
      اینترفیس شامل متدهای sendEmail و sendSms است. در نتیجه، EmailSender مجبور به پیاده‌سازی متد sendSms می‌شود که برایش نامرتبط است.
    </td>
  </tr>

  <tr>
    <td>DIP</td>
    <td>مورد نقص</td>
    <td>ReservationService.java</td>
    <td>
      ماژول سطح بالا (سرویس) به طور مستقیم به کلاس‌های سطح پایین وابسته است: new PaymentProcessor(), new EmailSender(), و new SmsSender().
    </td>
  </tr>

  <tr>
    <td>PLK</td>
    <td>مورد برقراری</td>
    <td>PaymentProcessor.java</td>
    <td>این کلاس تنها با پارامترهای مستقیم خود (مانند amount) تعامل دارد و با ساختار داخلی اشیاء دیگر را ارتباطی ندارد.</td>
  </tr>
  <tr>
    <td>PLK</td>
    <td>مورد نقص</td>
    <td>ReservationService.java</td>
    <td>
      دسترسی به داده‌ها از طریق زنجیره طولانی صورت می‌گیرد و متدهای آبجکت‌های داخلی را فراخوانی میکند: res.customer.name, res.customer.city, res.room.price, و res.customer.email.
    </td>
  </tr>

</table>




