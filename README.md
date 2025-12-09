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




<h2><b>گام سوم: (اصلاح موارد نقض)</b></h2>


<table dir="rtl">
<thead>
  <tr>
    <th align="center">اصول</th>
    <th align="center">نقص</th>
    <th align="center">رفع نقص</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td align="center">SRP</td>
    <td align="right"><div style="direction: rtl; text-align: right;">کلاس ReservationService مسئول ۴ حوزه (تخفیف، پرداخت، اعلان، جریان رزرو) بود. Payment processor انواع مختلف مسئولیت بر عهده دارد.</div></td>
    <td align="right"><div style="direction: rtl; text-align: right;">منطق تخفیف به Discount و ParisDiscount منتقل شد. منطق پرداخت به اینترفیس Payment و کلاس‌های Paypal, Cash, Card منتقل شد. منطق اعلان به کلاس‌های مجزای MessageSender و EmailSender منتقل شد.</div></td>
  </tr>
  <tr>
    <td align="center">OCP</td>
    <td align="right"><div style="direction: rtl; text-align: right;">برای افزودن پرداخت یا اعلان جدید، نیاز به اصلاح بلوک‌های switch در رزرویشن سرویس بود.</div></td>
    <td align="right"><div style="direction: rtl; text-align: right;">رزرویشن سرویس به جای استفاده از switch، فقط متد پرداخت یا ارسال را روی اینترفیس‌های massege sender ,payment فراخوانی می‌کند.</div></td>
  </tr>
  <tr>
    <td align="center">DIP</td>
    <td align="right"><div style="direction: rtl; text-align: right;">رزرویشن سرویس به کلاس‌های سطح پایین وابسته بود: new PaymentProcessor(), new EmailSender().</div></td>
    <td align="right"><div style="direction: rtl; text-align: right;">از اینترفیس‌ها (Payment, massege Sender, Discount) استفاده شد تا کلاس به متدهای کلاس‌های سطح پایین مثل payByCard یا sendEmail وابسته نباشد.</div></td>
  </tr>
  <tr>
    <td align="center">ISP</td>
    <td align="right"><div style="direction: rtl; text-align: right;">اینترفیس MessageSender.java دو متد نامرتبط داشت (sendEmail, sendSms).</div></td>
    <td align="right"><div style="direction: rtl; text-align: right;">اینترفیس MessageSender.java اصلاح شد تا هر کلاینت فقط به متدهای مورد نیاز خود وابسته باشد و مجبور به اجرای متدهای غیرمرتبط نباشد.</div></td>
  </tr>
  <tr>
    <td align="center">PLK</td>
    <td align="right"><div style="direction: rtl; text-align: right;">دسترسی زنجیره‌ای به داده‌ها: res.customer.name, res.room.price.</div></td>
    <td align="right"><div style="direction: rtl; text-align: right;">متدهای دسترسی تعریف شدند و ReservationService از این متدها برای دسترسی کپسوله ‌شده استفاده می‌کند.</div></td>
  </tr>
  <tr>
    <td align="center">کپسوله‌سازی</td>
    <td align="right"><div style="direction: rtl; text-align: right;">تغییر مستقیم قیمت اتاق.</div></td>
    <td align="right"><div style="direction: rtl; text-align: right;">منطق تخفیف به ParisDiscount منتقل شد و عامل تخفیف را برمی‌گرداند. این عامل روی یک متغیر محلی (finalPrice) اعمال می‌شود و فیلد اصلی قیمت اتاق تغییر نمی‌کند.</div></td>
  </tr>
</tbody>
</table>




<h2><b>گام چهارم: (ارزیابی)</b></h2>

<h3>قابلیت پرداخت حضوری:</h3>

<table>
  <tr>
    <th>قبل تغییر</th>
    <th>بعد تغییر</th>
  </tr>
  <tr>
    <td>اضافه کردن متد on Site Payment در کلاس <b>PaymentProcessor</b></td>
    <td>اضافه کردن کلاس <b>OnSitePayment</b></td>
  </tr>
  <tr>
    <td>افزودن case به دستور switch برای پرداخت حضوری در کلاس <b>ReservationService</b></td>
    <td></td>
  </tr>
</table>


<h3>قابلیت ارسال پیام:</h3>

<table>
  <tr>
    <th>قبل تغییر</th>
    <th>بعد تغییر</th>
  </tr>

  <tr>
    <td>افزودن تابع ارسال پیامک در کلاس <b>MessageSender</b></td>
    <td>اضافه کردن کلاس <b>SmsSender</b></td>
  </tr>

  <tr>
    <td>پیاده‌سازی متد جدید <b>sendSms</b> در کلاس جدید <b>SmsSender</b></td>
    <td></td>
  </tr>

  <tr>
    <td>افزودن کلاس <b>SmsSender</b> که واسط <b>MessageSender</b> را پیاده‌سازی می‌کند</td>
    <td></td>
  </tr>

  <tr>
    <td>
      افزودن <b>case</b> جدید در switch و ایجاد شیء از <b>SmsSender</b> و فراخوانی
      <b>sendSms</b> در کلاس <b>ReservationService</b>
    </td>
    <td></td>
  </tr>

</table>

</div>

