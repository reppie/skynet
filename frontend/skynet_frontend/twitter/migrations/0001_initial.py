# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Adding model 'Tweet'
        db.create_table('twitter_tweet', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('body', self.gf('django.db.models.fields.CharField')(max_length=140)),
            ('datetime', self.gf('django.db.models.fields.DateTimeField')()),
            ('twitter_id', self.gf('django.db.models.fields.BigIntegerField')()),
            ('username', self.gf('django.db.models.fields.CharField')(max_length=15)),
        ))
        db.send_create_signal('twitter', ['Tweet'])


    def backwards(self, orm):
        
        # Deleting model 'Tweet'
        db.delete_table('twitter_tweet')


    models = {
        'twitter.tweet': {
            'Meta': {'object_name': 'Tweet'},
            'body': ('django.db.models.fields.CharField', [], {'max_length': '140'}),
            'datetime': ('django.db.models.fields.DateTimeField', [], {}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'twitter_id': ('django.db.models.fields.BigIntegerField', [], {}),
            'username': ('django.db.models.fields.CharField', [], {'max_length': '15'})
        }
    }

    complete_apps = ['twitter']
