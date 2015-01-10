package com.wizky.housediary.wxapi;

import com.tencent.mm.sdk.modelbase.BaseReq;
import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;

public class GetAccessToken
{
  public static class Resp extends BaseResp
  {
    private static final String TAG = "MicroMsg.SDK.GetAccessToken.Resp";
    private static final int LENGTH_LIMIT = 1024;
    public String access_token;
    public Integer expires_in;
    public String refresh_token;
    public String openid;
    public String scope;

    public Resp()
    {
    }

    public Resp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }

    public int getType()
    {
      return 1;
    }

    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.access_token = paramBundle.getString("access_token");
      this.refresh_token = paramBundle.getString("refresh_token");
      this.openid = paramBundle.getString("openid");
      this.scope = paramBundle.getString("scope");
    }

    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("access_token", this.access_token);
      paramBundle.putString("refresh_token", this.refresh_token);
      paramBundle.putString("openid", this.openid);
      paramBundle.putString("scope", this.scope);
    }

    public boolean checkArgs()
    {
//      if ((this.state != null) && (this.state.length() > 1024))
//      {
//        a.a("MicroMsg.SDK.SendAuth.Resp", "checkArgs fail, state is invalid");
//        return false;
//      }
      return true;
    }
  }

  public static class Req extends BaseReq
  {
    private static final String TAG = "MicroMsg.SDK.GetAccessToken.Req";
    private static final int LENGTH_LIMIT = 1024;
    public String secret;
    public String code;
    public String grant_type;

    public Req()
    {
    }

    public Req(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }

    public int getType()
    {
      return 1;
    }

    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.secret = paramBundle.getString("secret");
      this.code = paramBundle.getString("code");
    }

    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("secret", this.secret);
      paramBundle.putString("code", this.code);
      paramBundle.putString("grant_type", "authorization_code");
    }

    public boolean checkArgs()
    {
      if ((this.code == null) || (this.code.length() == 0) || (this.code.length() > 1024))
      {
        a.a("MicroMsg.SDK.GetAccessToken.Req", "checkArgs fail, code is invalid");
        return false;
      }
      if ((this.secret != null) && (this.secret.length() > 1024))
      {
        a.a("MicroMsg.SDK.GetAccessToken.Req", "checkArgs fail, secret is invalid");
        return false;
      }
      return true;
    }
  }
}