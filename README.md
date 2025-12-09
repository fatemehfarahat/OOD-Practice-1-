# OOD-Practice-1-

###گام اول

<table dir="rtl">
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
