import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class CheesePlease3 extends Game
{
    public Stage mainStage;
    private BaseActor mousey;
    private BaseActor cheese;
    private BaseActor floor;
    private BaseActor winText;
    
    public void create() 
    {        
        mainStage = new Stage();
        
        floor = new BaseActor();
        floor.setTexture( new Texture(Gdx.files.internal("assets/tiles.jpg")) );
        floor.setPosition( 0, 0 );
        mainStage.addActor( floor );
        
        cheese = new BaseActor();
        cheese.setTexture( new Texture(Gdx.files.internal("assets/cheese.png")) );
        cheese.setPosition( 400, 300 );
        mainStage.addActor( cheese );
        
        mousey = new BaseActor();
        mousey.setTexture( new Texture(Gdx.files.internal("assets/mouse.png")) );
        mousey.setPosition( 20, 20 );
        mainStage.addActor( mousey );
        
        winText = new BaseActor();
        winText.setTexture( new Texture(Gdx.files.internal("assets/you-win.png")) );
        winText.setPosition( 170, 60 );
        winText.setVisible( false );
        mainStage.addActor( winText );
    }

    public void render() 
    {   
        // process input
        mousey.velocityX = 0;
        mousey.velocityY = 0;
        
        if (Gdx.input.isKeyPressed(Keys.LEFT)) 
            mousey.velocityX -= 100;
        if (Gdx.input.isKeyPressed(Keys.RIGHT))
            mousey.velocityX += 100;;
        if (Gdx.input.isKeyPressed(Keys.UP)) 
            mousey.velocityY += 100;
        if (Gdx.input.isKeyPressed(Keys.DOWN)) 
            mousey.velocityY -= 100;

        // update
        float dt = Gdx.graphics.getDeltaTime();
        mainStage.act(dt);
        
        // check win condition: mousey must be overlapping cheese
        Rectangle cheeseRectangle = cheese.getBoundingRectangle();
        Rectangle mouseyRectangle = mousey.getBoundingRectangle();
        
        if ( cheeseRectangle.contains(mouseyRectangle) )
            winText.setVisible( true );
        
        // draw graphics
        Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        mainStage.draw();
    }
}