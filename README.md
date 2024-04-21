# WechatAPI

Author: [Frank-Xiao2002](https://github.com/Frank-Xiao2002)

## Intro

This is a homework project for the junior year API course. We must integrate with WeChat's
[Official Accounts Platform](https://developers.weixin.qq.com/doc/offiaccount/en/Getting_Started/Overview.html)
to build a RESTful API service for job offers. We are allowed to take the public WeChat account
of [OfferShow](https://www.offershow.cn) as an example, and we do not need to implement the API as comprehensive as
the example account.

In my project, users can follow the WeChat public account **_xxj的公众号_** which is created by myself, send a text
message and receive a URI link, that is a web page hosted on the same backend server with the WeChat public account.
The web page shows a list of job offers. Besides, employers(based on the purpose of this homework, employers here means
everyone that has access to the website) can create, update, delete job offers on the website based on some basic
verification.

## Notice

If you want to run this project, be sure to add a file named `secrets.properties` in the `src/main/resources` directory.
This file must include your WeChat development id and secret, like this:

```properties
app.id=your_appid
app.secret=your_secret
```

Otherwise, the project will **NOT** run.