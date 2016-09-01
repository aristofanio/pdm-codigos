package ag.circimageview;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;


public class ImageViewCirc extends ImageView {

    public ImageViewCirc(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageViewCirc(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        //recupera o drawable inserido (se for um recurso drawable)
        Drawable drawable = getDrawable();
        //convert em imagem (se for imagem)
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        //recupera a imagem do drawable
        Bitmap bitmap = bitmapDrawable.getBitmap();
        //cria o bitmap resultando com base na origem
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        //cria um canvas para desenhar no 'output'
        Canvas outputCanvas = new Canvas(output);
        //cria um paint para pintar no 'output'
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setColor(Color.parseColor("#ff0000"));
        //criando as áreas do desenho
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());//src
        RectF oval = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight()); //dst
        //
        paint.setColor(Color.parseColor("#ff0000"));
        outputCanvas.drawOval(oval, paint);//dest
        paint.setColor(Color.parseColor("#ff8733"));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        outputCanvas.drawBitmap(bitmap, rect, oval, paint);
        //
        canvas.drawBitmap(output, 0, 0, null);
    }
}
