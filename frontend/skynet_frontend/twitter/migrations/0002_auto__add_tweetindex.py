# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Adding model 'TweetIndex'
        db.create_table('twitter_tweetindex', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('keyword', self.gf('django.db.models.fields.CharField')(max_length=140)),
        ))
        db.send_create_signal('twitter', ['TweetIndex'])


    def backwards(self, orm):
        
        # Deleting model 'TweetIndex'
        db.delete_table('twitter_tweetindex')


    models = {
        'twitter.tweet': {
            'Meta': {'object_name': 'Tweet'},
            'body': ('django.db.models.fields.CharField', [], {'max_length': '140'}),
            'datetime': ('django.db.models.fields.DateTimeField', [], {}),
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'twitter_id': ('django.db.models.fields.BigIntegerField', [], {}),
            'username': ('django.db.models.fields.CharField', [], {'max_length': '15'})
        },
        'twitter.tweetindex': {
            'Meta': {'object_name': 'TweetIndex'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'keyword': ('django.db.models.fields.CharField', [], {'max_length': '140'})
        }
    }

    complete_apps = ['twitter']
